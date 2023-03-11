package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LikeLockServiceFacade {

    private final ConcurrencyService concurrencyService;
    private final LikeService likeService;

    public LikeLockServiceFacade(ConcurrencyService concurrencyService, LikeService likeService) {
        this.concurrencyService = concurrencyService;
        this.likeService = likeService;
    }

    public void upLike(UUID id) {
        concurrencyService
                .execute(id.toString(),
                        () -> likeService.upLike(id));

    }
}
