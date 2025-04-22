package com.example.showperformance.performance.service;

import com.example.showperformance.performance.constant.PerformanceCode;
import com.example.showperformance.performance.domain.Performance;
import com.example.showperformance.performance.infrastructure.RestTemplatePerformanceRequester;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final RestTemplatePerformanceRequester performanceRequester;

    @Value("${api_key}")
    private String PERFORMANCE_API_KEY;


    @Cacheable(
            value = "performance",
            key = "#genre + '::' + #page",
            unless = "#result == null || #result.isEmpty()"
    )
    public List<Performance> performances(int page, String genre) {
        return performanceRequester.requestPerformances(
                PERFORMANCE_API_KEY,
                page,
                PerformanceCode.code(genre)
        );
    }
}
