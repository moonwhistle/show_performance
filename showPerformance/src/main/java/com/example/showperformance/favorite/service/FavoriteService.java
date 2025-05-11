package com.example.showperformance.favorite.service;

import com.example.showperformance.favorite.domain.Favorite;
import com.example.showperformance.favorite.repository.FavoriteRepository;
import com.example.showperformance.member.domain.member.Member;
import com.example.showperformance.member.service.MemberService;
import com.example.showperformance.performance.domain.Performance;
import com.example.showperformance.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final PerformanceService performanceService;
    private final MemberService memberService;

    public void performanceFavorite(Long memberId, String performanceId, String name, String area, String genreName, String startDate, String endDate, String posterUrl) {
        Member member = memberService.findMember(memberId);
        Performance performance = performanceService.saveIfNotExist(
                new Performance(performanceId, name, area, genreName, startDate, endDate, posterUrl)
        );

        deleteOrAddFavorite(member, performance);
    }

    private void deleteOrAddFavorite(Member member, Performance performance) {
        if(favoriteRepository.existsByMemberAndPerformance(member, performance)) {
            favoriteRepository.deleteByMemberAndPerformance(member, performance);
        } else {
            favoriteRepository.save(new Favorite(member, performance));
        }
    }
}
