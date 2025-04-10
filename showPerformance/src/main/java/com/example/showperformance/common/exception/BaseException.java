package com.example.showperformance.common.exception;

public class BaseException extends RuntimeException{

    private final BaseErrorCode errorCode;

    public BaseException(BaseErrorCode errorCode) {
        super(errorCode.customCode() + ": " + errorCode.message());
        this.errorCode = errorCode;
    }

    public BaseErrorCode baseErrorCode() {
        return errorCode;
    }
}
