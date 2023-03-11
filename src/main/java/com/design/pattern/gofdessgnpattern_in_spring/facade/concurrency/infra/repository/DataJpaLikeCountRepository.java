package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.infra.repository;

import com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain.LikeCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataJpaLikeCountRepository extends JpaRepository<LikeCount, UUID> {

}
