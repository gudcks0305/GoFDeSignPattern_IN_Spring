package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.strategy;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy.RockProcessor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
@Component("redissonLock")
public class RedissonLock implements RockProcessor {
    private final RedissonClient redissonClient;

    public RedissonLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public Object execute(String key, Callable callable) {
        RLock lock = redissonClient.getLock("lock:" + key);
        lock.lock();
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
