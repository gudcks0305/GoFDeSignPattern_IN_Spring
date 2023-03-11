package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.strategy;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy.RockProcessor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;

@Component("lettuceLock")
public class LettuceRedisLock implements RockProcessor {
    private final RedisTemplate<String, String> redisTemplate;

    public LettuceRedisLock(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void execute(String key, Runnable... runnable) {
        redisTemplate.execute(new SessionCallback<>() {
            @Override
            public Object execute(RedisOperations operations) throws RuntimeException {
                operations.watch("lock:" + key);
                operations.multi();
                for (Runnable r : runnable) {
                    r.run();
                }
                return operations.exec();
            }
        });
    }
}
