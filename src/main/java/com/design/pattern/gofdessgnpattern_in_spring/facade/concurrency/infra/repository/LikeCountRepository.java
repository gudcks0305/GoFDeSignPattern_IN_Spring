package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.repository;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.LikeCount;

import java.util.UUID;

public interface LikeCountRepository {
   LikeCount findById(UUID id);
   void flush();
}
