package com.example.showperformance.rank.controller;

import com.example.showperformance.rank.controller.dto.RankResponses;
import com.example.showperformance.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;

    @GetMapping("/ranks")
    public ResponseEntity<RankResponses> showRankPerformance() {
        RankResponses rankResponses = new RankResponses(rankService.ranks());
        return ResponseEntity.ok(rankResponses);
    }
}
