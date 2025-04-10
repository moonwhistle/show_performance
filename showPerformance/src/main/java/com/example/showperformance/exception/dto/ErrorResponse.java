package com.example.showperformance.exception.dto;

public record ErrorResponse(
        String customCode,
        String message
) {
}
