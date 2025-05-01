package com.example.showperformance.member.service;

import com.example.showperformance.member.service.client.GoogleOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {

    private final GoogleOAuthClient client;

    public String getUrl() {
        return client.getUrI();
    }
}
