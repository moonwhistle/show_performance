package com.example.showperformance.performance.controller.dto;

import com.example.showperformance.performance.infrastructure.dto.DetailPerformance;
import java.util.List;

public record DetailPerformanceResponses(
        List<DetailPerformance> detailPerformances
) {
}
