package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy;

import java.util.concurrent.Callable;

public interface RockProcessor<T> {
    Object execute(String key, Callable<T> runnable);
}
