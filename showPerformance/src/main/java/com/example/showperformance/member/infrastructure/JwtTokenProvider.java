package com.example.showperformance.member.infrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.showperformance.common.exception.BaseException;
import com.example.showperformance.common.util.DateUtil;
import com.example.showperformance.global.exception.GlobalErrorCode;
import com.example.showperformance.member.domain.auth.TokenProvider;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider implements TokenProvider {

    private static final String KEY_CLAIMER = "memberId";

    private final Algorithm algorithm;
    private final long expirationPeriod;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey,
                            @Value("${jwt.expiration-period}") long expirationPeriod) {
        this.algorithm = Algorithm.HMAC256(secretKey);
        this.expirationPeriod = expirationPeriod;
    }

    @Override
    public String create(Long memberId) {
        return JWT.create()
                .withClaim(KEY_CLAIMER, memberId)
                .withIssuedAt(DateUtil.issuedDate())
                .withExpiresAt(DateUtil.expiredDate(expirationPeriod))
                .withJWTId(UUID.randomUUID().toString())
                .sign(algorithm);
    }

    @Override
    public Long extractMemberId(String token) {
        try {
            return extractToken(token);
        } catch (JWTDecodeException e) {
            throw new BaseException(GlobalErrorCode.TOKEN_DECODED_EXCEPTION);
        } catch (TokenExpiredException e) {
            throw new BaseException(GlobalErrorCode.TOKEN_EXPIRATION_EXCEPTION);
        }
    }

    private Long extractToken(String token) {
        return verifyToken(token).getClaim(KEY_CLAIMER)
                .asLong();
    }

    private DecodedJWT verifyToken(String token) {
        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        try {
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new BaseException(GlobalErrorCode.TOKEN_VERIFICATION_EXCEPTION);
        }
    }
}
