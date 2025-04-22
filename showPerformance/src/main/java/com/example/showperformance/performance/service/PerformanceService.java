package com.example.showperformance.performance.service;

import com.example.showperformance.performance.constant.AreaCode;
import com.example.showperformance.performance.constant.GenreCode;
import com.example.showperformance.performance.infrastructure.dto.DetailPerformance;
import com.example.showperformance.performance.infrastructure.dto.Performance;
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
            value = "genrePerformance",
            key = "#genre + '::' + #page",
            unless = "#result == null || #result.isEmpty()"
    )
    public List<Performance> genrePerformances(int page, String genre) {
        return performanceRequester.requestPerformancesByGenre(
                PERFORMANCE_API_KEY,
                page,
                GenreCode.code(genre)
        );
    }

    @Cacheable(
            value = "areaPerformance",
            key = "#area + '::' + #page",
            unless = "#result == null || #result.isEmpty()"
    )
    public List<Performance> areaPerformances(int page, String area) {
        return performanceRequester.requestPerformancesByArea(
                PERFORMANCE_API_KEY,
                page,
                AreaCode.code(area)
        );
    }

    public List<DetailPerformance> detailPerformance(String performanceId) {
        return performanceRequester.requestDetailPerformance(
                PERFORMANCE_API_KEY,
                performanceId
        );
    }
}
