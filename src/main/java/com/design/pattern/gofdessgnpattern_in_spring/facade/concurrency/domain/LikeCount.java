package com.design.pattern.gofdessgnpattern_in_spring.facade.concurrency.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class LikeCount {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private int count;
    protected LikeCount() {

    }
    public LikeCount(UUID id) {
        this.id = id;
        this.count = 0;
    }
    public UUID getId() {
        return id;
    }

    public int upLike() {
        return ++count;
    }
    public int downLike() {
        return --count;
    }


    public int getCurrentLike() {
        return count;
    }
    @Override
    public String toString() {
        return "LikeCount{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
