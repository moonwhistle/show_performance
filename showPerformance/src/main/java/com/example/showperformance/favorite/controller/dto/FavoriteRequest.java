package com.example.showperformance.favorite.controller.dto;

public record FavoriteRequest(
        String perform,
        String area,
        String genreName,
        String startDate,
        String endDate,
        String posterUrl
) {
}
