package com.example.showperformance.rank.service;

import com.example.showperformance.rank.domain.Rank;
import com.example.showperformance.rank.infrastructure.RestTemplateRankRequester;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RankService {

    private final RestTemplateRankRequester rankRequester;

    @Value("${api_key}")
    private String PERFORMANCE_API_KEY;

    @Cacheable(value = "rank")
    public List<Rank> ranks() {
        return rankRequester.requestRanks(PERFORMANCE_API_KEY);
    }
}
