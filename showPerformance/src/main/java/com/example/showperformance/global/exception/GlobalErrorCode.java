package com.example.showperformance.global.exception;

import com.example.showperformance.common.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum GlobalErrorCode implements BaseErrorCode {
    TOKEN_VERIFICATION_EXCEPTION(HttpStatus.NOT_FOUND, "T001", "토큰을 확인할 수 없습니다."),
    TOKEN_EXPIRATION_EXCEPTION(HttpStatus.CONFLICT, "T002", "토큰이 만료되었습니다."),
    TOKEN_DECODED_EXCEPTION(HttpStatus.CONFLICT, "T003", "토큰을 확인할 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String customCode;
    private final String message;

    GlobalErrorCode(HttpStatus httpStatus, String customCode, String message) {
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
