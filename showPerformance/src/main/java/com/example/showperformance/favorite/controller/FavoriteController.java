package com.example.showperformance.favorite.controller;

import com.example.showperformance.favorite.controller.dto.FavoriteRequest;
import com.example.showperformance.favorite.controller.dto.FavoriteResponse;
import com.example.showperformance.favorite.domain.Favorite;
import com.example.showperformance.favorite.service.FavoriteService;
import com.example.showperformance.global.resolver.annotation.Auth;
import com.example.showperformance.performance.domain.Performance;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/favorites")
    public ResponseEntity<FavoriteResponse> showFavorites(
            @Auth Long memberId,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Page<Favorite> favoritePage = favoriteService.showMemberFavoritePerformance(memberId, page, size);
        List<Performance> content = favoritePage.getContent()
                .stream()
                .map(Favorite::getPerformance)
                .toList();

        return ResponseEntity.ok(new FavoriteResponse(
                content,
                favoritePage.getNumber(),
                favoritePage.getSize(),
                favoritePage.getTotalPages(),
                favoritePage.getTotalElements(),
                favoritePage.isFirst(),
                favoritePage.isLast()
        ));
    }
}
