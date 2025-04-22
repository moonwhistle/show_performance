package com.example.showperformance.performance.exception;

import com.example.showperformance.common.exception.BaseErrorCode;
import com.example.showperformance.common.exception.BaseException;

public class PerformanceException extends BaseException {

    public PerformanceException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
