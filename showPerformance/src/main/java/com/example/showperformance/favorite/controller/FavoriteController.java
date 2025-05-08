package com.example.showperformance.favorite.controller;

import com.example.showperformance.favorite.controller.dto.FavoriteRequest;
import com.example.showperformance.favorite.service.FavoriteService;
import com.example.showperformance.global.resolver.annotation.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite/{performanceId}")
    public ResponseEntity<Void> favoritePerformance(
            @PathVariable String performanceId,
            @RequestBody FavoriteRequest request,
            @Auth Long memberId
    ) {
        favoriteService.performanceFavorite(
                memberId, performanceId,
                request.name(), request.area(),
                request.genreName(), request.startDate(),
                request.endDate(), request.posterUrl()
        );
        return ResponseEntity.ok()
                .build();
    }
}
