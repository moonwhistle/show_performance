package com.example.showperformance.performance.controller;

import com.example.showperformance.performance.domain.Performance;
import com.example.showperformance.performance.service.PerformanceService;
import java.util.List;
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
    public ResponseEntity<List<Performance>> showPerformances(
            @RequestParam String genre,
            @RequestParam int page
    ) {
        List<Performance> performances =  performanceService.performance(page, genre);
        return ResponseEntity.ok(performances);
    }
}
