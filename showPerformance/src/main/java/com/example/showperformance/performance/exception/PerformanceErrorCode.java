package com.example.showperformance.performance.exception;

import com.example.showperformance.common.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum PerformanceErrorCode implements BaseErrorCode {

    NOT_FOUND_GENRE(HttpStatus.NOT_FOUND, "G001", "해당 장르를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String customCode;
    private final String message;

    PerformanceErrorCode(HttpStatus httpStatus, String customCode, String message) {
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
