package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.strategy;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy.RockProcessor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component("redissonLock")
public class RedissonLock implements RockProcessor {
    private final RedissonClient redissonClient;

    public RedissonLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void execute(String key, Runnable... runnable) {
        RLock lock = redissonClient.getLock("lock:" + key);
        lock.lock();
        try {
            for (Runnable r : runnable) {
                r.run();
            }
        } finally {
            lock.unlock();
        }
    }
}
