package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.service;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.LikeCount;
import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.repository.LikeCountRepository;
import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.strategy.RockProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class LikeService {

    private final LikeCountRepository likeCountRepository;

    public LikeService(LikeCountRepository likeCountRepository) {
        this.likeCountRepository = likeCountRepository;
    }

    public void upLike(UUID id) {
        LikeCount likeCount = findById(id);
        likeCount.upLike();
    }

    public void downLike(UUID id) {
        LikeCount likeCount = findById(id);
        likeCount.downLike();
    }

    private LikeCount findById(UUID id) {
        LikeCount likeCount = likeCountRepository.findById(id);
        if (likeCount == null) {
            throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        }
        return likeCount;
    }
}
