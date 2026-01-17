package com.example.springbootcommon.redis;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 缓存服务
 * @author wutong
 * @date 2023/12/14
 */
@Service
public class CacheService {
    @Autowired
    private RedisService redisService;

    /**
     * 获取或设置缓存值
     * @param key 缓存键
     * @param supplier 缓存值供应商
     * @param timeout 缓存过期时间
     * @param unit 时间单位
     * @param <T> 缓存值类型
     * @return 缓存值
     */
    public <T> T getOrSet(String key, Supplier<T> supplier, long timeout, TimeUnit unit) {
        T value = (T) redisService.get(key);
        if (value == null) {
            value = supplier.get();
            if (value != null) {
                redisService.set(key, value, timeout, unit);
            }
        }
        return value;
    }

    /**
     * 带缓存的获取用户方法
     * @param userId 用户ID
     * @return 用户缓存值
     */
    @Cacheable(value = "userCache", key = "#userId")
    public Object getUserById(Long userId) {
        return null;
    }

    /**
     * 更新缓存
     */
    @CachePut(value = "user", key = "#user.id")
    public Object updateUser(Object user) {
        // 更新数据库
        return user;
    }

    /**
     * 删除缓存
     */
    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(Long id) {
        // 删除数据库记录
    }

    /**
     * 批量删除缓存
     */
    @CacheEvict(value = "user", allEntries = true)
    public void clearAllUserCache() {
        // 清除所有用户缓存
    }


    /**
     * 设置缓存并返回旧值
     */
    public Object getAndSet(String key, Object value, long timeout, TimeUnit unit) {
        Object oldValue = redisService.get(key);
        redisService.set(key, value, timeout, unit);
        return oldValue;
    }
}
