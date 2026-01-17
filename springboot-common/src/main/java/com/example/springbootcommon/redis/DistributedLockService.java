package com.example.springbootcommon.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁服务
 * @author wutong
 * @date 2023/12/14
 */
@Service
public class DistributedLockService {

    private final Logger log = LoggerFactory.getLogger(DistributedLockService.class);

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 获取分布式锁
     * @param lockName 锁名称
     * @return 锁对象
     */
    public RLock getLock(String lockName) {
        return redissonClient.getLock(lockName);
    }

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁名称
     * @param waitTime 等待时间
     * @param leaseTime 锁持有时间
     * @param unit 时间单位
     * @return 是否获取成功
     * @throws InterruptedException 线程中断异常
     */
    public Boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            log.error("获取分布式锁失败，lockKey:{}", lockKey, e);
            Thread.currentThread().interrupt();
            throw e;
        }

    }

     /**
      * 释放分布式锁
      * @param lockKey 锁对象
      */
    public void releaseLock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }

    /**
     * 执行带锁的任务
     * @param lockKey 锁名称
     * @param waitTime 等待时间
     * @param leaseTime 锁持有时间
     * @param unit 时间单位
     * @param callable 任务
     * @return 任务执行结果
     * @throws Exception 任务执行异常
     */
    public <T> T executeWithLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit, LockTask<T> callable) throws Exception {
        Boolean locked = tryLock(lockKey, waitTime, leaseTime, unit);
        if (locked) {
            try {
                return callable.execute();
            } finally {
                releaseLock(lockKey);
            }
        } else {
            throw new RuntimeException("Failed to acquire lock: " + lockKey);
        }
    }

    /**
     * 执行带锁的任务，默认等待时间10秒，锁持有时间30秒
     * @param lockKey 锁名称
     * @param task 任务
     * @throws Exception 任务执行异常
     */
    public void executeWithLock(String lockKey, Runnable task) throws Exception {
        executeWithLock(lockKey, 10, 30, TimeUnit.SECONDS, () -> {
            task.run();
            return null;
        });
    }

     /**
      * 带锁任务接口
      * @param <T> 任务执行结果类型
      */
    @FunctionalInterface
    public interface LockTask<T> {
        T execute() throws Exception;
    }
}
