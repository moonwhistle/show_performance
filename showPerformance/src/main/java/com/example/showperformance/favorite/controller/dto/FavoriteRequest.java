package com.example.showperformance.favorite.controller.dto;

public record FavoriteRequest(
        String name,
        String area,
        String genreName,
        String startDate,
        String endDate,
        String posterUrl
) {
}
