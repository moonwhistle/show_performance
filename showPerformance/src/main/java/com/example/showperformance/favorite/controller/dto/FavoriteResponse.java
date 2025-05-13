package com.example.showperformance.favorite.controller.dto;

import com.example.showperformance.performance.domain.Performance;
import java.util.List;

public record FavoriteResponse(
        List<Performance> content
) {
}
