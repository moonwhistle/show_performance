package com.example.showperformance.performance.controller.dto;

import com.example.showperformance.performance.domain.Performance;
import java.util.List;

public record PerformanceResponses(
        List<Performance> performances
) {
}
