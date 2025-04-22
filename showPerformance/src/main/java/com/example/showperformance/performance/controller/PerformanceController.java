package com.example.showperformance.performance.controller;

import com.example.showperformance.performance.controller.dto.PerformanceResponses;
import com.example.showperformance.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService performanceService;

    @GetMapping("/genre/performances")
    public ResponseEntity<PerformanceResponses> showGenrePerformances(
            @RequestParam String genre,
            @RequestParam int page
    ) {
        PerformanceResponses performances =  new PerformanceResponses(performanceService.genrePerformances(page, genre));
        return ResponseEntity.ok(performances);
    }

    @GetMapping("/area/performances")
    public ResponseEntity<PerformanceResponses> showAreaPerformances(
            @RequestParam int page,
            @RequestParam String area
    ) {
        PerformanceResponses performances = new PerformanceResponses(performanceService.areaPerformances(page, area));
        return ResponseEntity.ok(performances);
    }
}
