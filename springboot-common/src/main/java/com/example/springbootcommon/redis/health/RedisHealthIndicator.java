package com.example.springbootcommon.redis.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * Redis健康检查指示器
 * @author wutong
 * @date 2025/10/16
 */
@Component
public class RedisHealthIndicator implements HealthIndicator {

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisHealthIndicator(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public Health health() {
        try {
            // 测试Redis连接
            String result = redisConnectionFactory.getConnection().ping();
            if ("PONG".equals(result)) {
                return Health.up().withDetail("message", "Redis connection successful").build();
            } else {
                return Health.down().withDetail("error", "Redis ping failed").build();
            }
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
    }
}
