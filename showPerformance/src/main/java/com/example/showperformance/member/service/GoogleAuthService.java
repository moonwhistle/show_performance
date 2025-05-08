package com.example.showperformance.member.service;

import com.example.showperformance.member.controller.auth.dto.GoogleUserResponse;
import com.example.showperformance.member.domain.member.Member;
import com.example.showperformance.member.infrastructure.JwtTokenProvider;
import com.example.showperformance.member.repository.MemberRepository;
import com.example.showperformance.member.service.client.GoogleOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {

    private final GoogleOAuthClient client;
    private final MemberRepository memberRepository;
    private final JwtTokenProvider tokenProvider;

    public String getUrl() {
        return client.getUrI();
    }

    public String login(String code) {
        GoogleUserResponse response = getUser(code);
        Member member = saveIfNotExist(response.email());

        return tokenProvider.create(member.getId());
    }

    private GoogleUserResponse getUser(String code) {
        return client.getUserInfo(code);
    }

    private Member saveIfNotExist(String email) {
        return memberRepository.findByEmail(email)
                .orElseGet(() -> memberRepository.save(new Member(email)));
    }
}
