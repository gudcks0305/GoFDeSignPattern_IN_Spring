package com.design.pattern.gofdessgnpattern_in_spring.global.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("uuidGenerator")
public class UUIDGenerator implements EntityIDGenerator {
    @Override
    public UUID generate() {
        return java.util.UUID.randomUUID();
    }
}
