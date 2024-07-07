package com.pickple.server.global.exception;

import com.pickple.server.global.response.ApiResponseDto;
import com.pickple.server.global.response.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 존재하지 않는 요청에 대한 예외
    @ExceptionHandler(value = {NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class})
    public ApiResponseDto<?> handleNoPageFoundException(Exception e) {
        log.error("GlobalExceptionHandler catch NoHandlerFoundException : {}", e.getMessage());
        return ApiResponseDto.fail(ErrorCode.NOT_FOUND_END_POINT);
    }

    // 기본 예외
    @ExceptionHandler(value = {Exception.class})
    public ApiResponseDto<?> handleException(Exception e) {
        log.error("handleException() in GlobalExceptionHandler throw Exception : {}", e.getMessage());
        e.printStackTrace();
        return ApiResponseDto.fail(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}