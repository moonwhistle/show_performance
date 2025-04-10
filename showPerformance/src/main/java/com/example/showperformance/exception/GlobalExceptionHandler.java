package com.example.showperformance.exception;

import com.example.showperformance.common.exception.BaseErrorCode;
import com.example.showperformance.common.exception.BaseException;
import com.example.showperformance.exception.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleException(BaseException e) {
        BaseErrorCode baseErrorCode = e.baseErrorCode();
        ErrorResponse response = new ErrorResponse(
                baseErrorCode.customCode(),
                baseErrorCode.message()
        );

        return ResponseEntity.status(baseErrorCode.httpStatus()).body(response);
    }
}
