package com.example.showperformance.member.service.client;

import com.example.showperformance.member.controller.auth.dto.GoogleTokenResponse;
import com.example.showperformance.member.controller.auth.dto.GoogleUserResponse;
import com.example.showperformance.member.domain.auth.OAuthClient;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    public GoogleUserResponse getUserInfo(String code) {
        String token = getAccessToken(code);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 사용자 정보를 요청
        ResponseEntity<GoogleUserResponse> response = restTemplate.exchange(
                USER_INFO_URL, HttpMethod.GET, entity, GoogleUserResponse.class);

        return response.getBody();
    }

    private String getAccessToken(String code) {
        String decode = URLDecoder.decode(code, StandardCharsets.UTF_8);
        MultiValueMap<String, String> params = setTokenRequestParameter(decode);

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<GoogleTokenResponse> response = makeTokenRequest(request);
        return Objects.requireNonNull(response.getBody()).access_token();
    }

    private MultiValueMap<String, String> setTokenRequestParameter(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        return params;
    }

    private ResponseEntity<GoogleTokenResponse> makeTokenRequest(HttpEntity<MultiValueMap<String, String>> request) {
        return restTemplate.postForEntity(TOKEN_URL, request, GoogleTokenResponse.class);
    }
}
