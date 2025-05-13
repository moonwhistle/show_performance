package com.example.showperformance.favorite.repository;

import com.example.showperformance.favorite.domain.Favorite;
import com.example.showperformance.member.domain.member.Member;
import com.example.showperformance.performance.domain.Performance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    boolean existsByMemberAndPerformance(Member member, Performance performance);
    void deleteByMemberAndPerformance(Member member, Performance performance);

    @Query("SELECT f FROM Favorite f JOIN FETCH f.performance WHERE f.member.id = :memberId")
    List<Favorite> findAllByMemberId(@Param("memberId") Long memberId);
}
