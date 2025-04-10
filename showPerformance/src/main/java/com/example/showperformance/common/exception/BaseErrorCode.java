package com.example.showperformance.common.exception;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {

    HttpStatus httpStatus();
    String customCode();
    String message();
}
