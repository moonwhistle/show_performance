package com.example.showperformance.member.service;

import com.example.showperformance.common.exception.BaseException;
import com.example.showperformance.member.domain.member.Member;
import com.example.showperformance.member.exception.MemberErrorCode;
import com.example.showperformance.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BaseException(MemberErrorCode.NOT_FOUND_MEMBER));
    }
}
