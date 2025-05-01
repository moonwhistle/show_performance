package com.example.showperformance.member.controller.auth;

import com.example.showperformance.member.controller.auth.dto.JwtTokenResponse;
import com.example.showperformance.member.controller.auth.dto.UrlResponse;
import com.example.showperformance.member.service.GoogleAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoogleAuthController {

    private final GoogleAuthService googleAuthService;

    @GetMapping("/google/login")
    public ResponseEntity<UrlResponse> login() {
        return ResponseEntity.ok(new UrlResponse(googleAuthService.getUrl()));
    }

    @PostMapping("/google/callback")
    public ResponseEntity<JwtTokenResponse> callback(@RequestParam("code") String code) {
        return ResponseEntity.ok(new JwtTokenResponse(googleAuthService.login(code)));
    }
}
