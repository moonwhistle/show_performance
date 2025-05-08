package com.example.showperformance.favorite.domain;

import com.example.showperformance.member.domain.member.Member;
import com.example.showperformance.performance.domain.Performance;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Performance performance;

    public Favorite(Member member, Performance performance) {
        this.member = member;
        this.performance = performance;
    }
}
