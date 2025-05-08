package com.example.showperformance.favorite.repository;

import com.example.showperformance.favorite.domain.Favorite;
import com.example.showperformance.member.domain.member.Member;
import com.example.showperformance.performance.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    boolean existsByMemberAndPerformance(Member member, Performance performance);
    void deleteByMemberAndPerformance(Member member, Performance performance);
}
