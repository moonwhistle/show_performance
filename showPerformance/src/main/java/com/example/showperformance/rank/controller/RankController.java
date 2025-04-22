package com.example.showperformance.rank.controller;

import com.example.showperformance.rank.domain.Ranks;
import com.example.showperformance.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankService service;

    @GetMapping("/ranks")
    public ResponseEntity<Ranks> showRankPerformance() {
        return ResponseEntity.ok(service.ranks());
    }
}
