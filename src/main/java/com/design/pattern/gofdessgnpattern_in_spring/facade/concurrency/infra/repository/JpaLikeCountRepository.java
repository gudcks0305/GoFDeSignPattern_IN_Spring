package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.repository;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.LikeCount;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("jpaLikeCountRepository")
public class JpaLikeCountRepository implements LikeCountRepository{
    private final DataJpaLikeCountRepository dataJpaLikeCountRepository;

    public JpaLikeCountRepository(DataJpaLikeCountRepository dataJpaLikeCountRepository) {
        this.dataJpaLikeCountRepository = dataJpaLikeCountRepository;
    }

    @Override
    public LikeCount findById(UUID id) {
        return dataJpaLikeCountRepository.findById(id).orElse(null);
    }

    @Override
    public void flush() {
        dataJpaLikeCountRepository.flush();
    }
}
