package com.example.showperformance.member.controller.auth.dto;

public record GoogleTokenResponse(
        String access_token,
        String token_type,
        String expires_in,
        String id_token
) {
}
