package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.service;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy.RockProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConcurrencyService {
    private final RockProcessor rockProcessor;

    public ConcurrencyService(@Qualifier("redissonLock") RockProcessor rockProcessor) {
        this.rockProcessor = rockProcessor;
    }

    public void execute(String key, Runnable... task) {
        rockProcessor.execute(key, task);
    }
}
