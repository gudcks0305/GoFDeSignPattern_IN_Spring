package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.service;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.service.LikeService;
import com.design.pattern.gofdessgnpattern_in_spring.global.utils.EntityIDGenerator;
import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.LikeCount;
import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.repository.DataJpaLikeCountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LikeServiceTest {
    @Autowired
    private EntityIDGenerator entityIDGenerator;
    @Autowired
    private LikeService likeService;
    @Autowired
    private DataJpaLikeCountRepository dataJpaLikeCountRepository;

    @BeforeEach
    void setUp() {
        dataJpaLikeCountRepository.deleteAll();
    }




    @Test
    @DisplayName("Service : 좋아요 up 동시성 테스트 without  Lock")
    void upLikeWithOutLock() {
        UUID id = (UUID) entityIDGenerator.generate();
        dataJpaLikeCountRepository.save(new LikeCount(id));
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                likeService.upLike(id);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LikeCount likeCount = dataJpaLikeCountRepository.findById(id).orElse(null);
        assertNotEquals(100, likeCount.getCurrentLike());

    }

    @Test
    @DisplayName("저장 테스트")
    void save() {
        UUID id = (UUID) entityIDGenerator.generate();
        dataJpaLikeCountRepository.saveAndFlush(new LikeCount(id));
        LikeCount likeCount = dataJpaLikeCountRepository.findById(id).orElse(null);
        assertNotNull(likeCount);
    }
}