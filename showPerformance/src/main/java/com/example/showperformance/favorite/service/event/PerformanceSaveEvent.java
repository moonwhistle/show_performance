package com.example.showperformance.favorite.service.event;

import com.example.showperformance.performance.domain.Performance;

public record PerformanceSaveEvent(
        Performance performance
) {
}
