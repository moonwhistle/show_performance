package com.example.showperformance.member.exception;

import com.example.showperformance.common.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum MemberErrorCode implements BaseErrorCode {

    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "M001", "유저를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String customCode;
    private final String message;

    MemberErrorCode(HttpStatus httpStatus, String customCode, String message) {
        this.httpStatus = httpStatus;
        this.customCode = customCode;
        this.message = message;
    }

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String customCode() {
        return customCode;
    }

    @Override
    public String message() {
        return message;
    }
}
