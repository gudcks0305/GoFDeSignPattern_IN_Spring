package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy;

public interface RockProcessor {
    void execute(String key, Runnable... runnable);
}
