package com.example.showperformance.member.service.client;

import com.example.showperformance.member.domain.auth.OAuthClient;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class GoogleOAuthClient implements OAuthClient {

    private static final String AUTH_URL = "https://accounts.google.com/o/oauth2/auth";
    private static final String TOKEN_URL = "https://oauth2.googleapis.com/token";
    private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v3/userinfo";

    private final RestTemplate restTemplate;

    @Value("${google_client_id}")
    private String clientId;

    @Value("${google_client_secret}")
    private String clientSecret;

    @Value("${google_oauth_redirection_url}")
    private String redirectUri;

    @Value("${google_oauth-scope}")
    private String scope;

    @Override
    public String getUrI() {
        return AUTH_URL + "?client_id=" + clientId +
                "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8) +
                "&response_type=code" +
                "&scope=" + URLEncoder.encode(scope, StandardCharsets.UTF_8) +
                "&access_type=offline";
    }
}
