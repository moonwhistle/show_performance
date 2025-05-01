package com.example.showperformance.member.controller.auth;

import com.example.showperformance.member.service.GoogleAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoogleAuthController {

    private final GoogleAuthService googleAuthService;

    @PostMapping("/google/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok(googleAuthService.getUrl());
    }
}
