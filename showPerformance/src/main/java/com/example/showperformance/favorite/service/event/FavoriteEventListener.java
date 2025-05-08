package com.example.showperformance.favorite.service.event;

import com.example.showperformance.performance.domain.Performance;
import com.example.showperformance.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class FavoriteEventListener {

    private final PerformanceService performanceService;

    @Transactional
    @EventListener
    public Performance handleFavoriteEvent(PerformanceSaveEvent event) {
        return performanceService.saveIfNotExist(event.performance());
    }
}
