package com.example.showperformance.global.exception.dto;

public record ErrorResponse(
        String customCode,
        String message
) {
}
