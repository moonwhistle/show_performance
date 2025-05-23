package com.example.showperformance.global.resolver;

import com.example.showperformance.common.exception.BaseException;
import com.example.showperformance.global.exception.GlobalErrorCode;
import com.example.showperformance.global.resolver.annotation.Auth;
import com.example.showperformance.member.infrastructure.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class AuthArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String TOKEN_HEADER_NAME = "Authorization";
    private static final String TOKEN_START_NAME = "Bearer ";
    private static final int TOKEN_BODY_DELIMITER = 7;

    private final JwtTokenProvider tokenProvider;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Auth.class) && parameter.getParameterType() == Long.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String tokenHeader = request.getHeader(TOKEN_HEADER_NAME);
        validateToken(tokenHeader);
        String token = tokenHeader.substring(TOKEN_BODY_DELIMITER);

        return tokenProvider.extractMemberId(token);
    }

    private void validateToken(String token) {
        if(token == null || !token.startsWith(TOKEN_START_NAME)) {
            throw new BaseException(GlobalErrorCode.TOKEN_NOT_FOUND_EXCEPTION);
        }
    }
}
