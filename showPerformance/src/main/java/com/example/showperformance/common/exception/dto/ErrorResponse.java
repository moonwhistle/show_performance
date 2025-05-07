package com.example.showperformance.common.exception.dto;

public record ErrorResponse(
        String customCode,
        String message
) {
}
