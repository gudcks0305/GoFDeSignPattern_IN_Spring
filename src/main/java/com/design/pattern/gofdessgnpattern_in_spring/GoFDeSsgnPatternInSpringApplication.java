package com.design.pattern.gofdessgnpattern_in_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class GoFDeSsgnPatternInSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoFDeSsgnPatternInSpringApplication.class, args);
    }

}
