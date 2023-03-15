package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.strategy;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy.RockProcessor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component("lettuceLock")
public class LettuceRedisLock implements RockProcessor {
    private final RedisTemplate<String, String> redisTemplate;

    public LettuceRedisLock(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Object execute(String key, Callable callable) {
        redisTemplate.execute(new SessionCallback<>() {
            @Override
            public Object execute(RedisOperations operations) throws RuntimeException {
                operations.watch("lock:" + key);
                operations.multi();
                try {
                    callable.call();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return operations.exec();
            }
        });
        return null;
    }

}
