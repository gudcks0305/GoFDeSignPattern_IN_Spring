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
    // 좋아요 증가
    // Facade 패턴을 사용하여, 좋아요 증가 기능을 구현한다.
    // 여기서 Facade 패턴이 필요한 이유는 트랜잭션의 문제이다.
    // LikeService.upLike() 메서드는 트랜잭션을 사용하고 있다.
    // 따라서 매서드 외부에서 트랜잭션을 처리하는 프록시가 동작하게 되는데
    // 락의 획득과 해제가 해당 매서드 내부에서 동작하는 형태일 경우
    // rock이 해제될 때 다른 스레드에서 락을 획득할 수 있기 때문이다. ( 커밋 전 Lock 획득이 일어남 )

    // 따라서 트랜잭션을 사용하는 매서드를 호출하기 전에 락을 획득하고
    // 트랜잭션을 사용하는 매서드를 호출한 후에 락을 해제하는 형태로 구현해야 한다.


    public void upLike(UUID id) {
        concurrencyService
                .execute(id.toString(),
                        () -> likeService.upLike(id));

    }
}
