package com.pickple.server.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    // 200 OK
    LOGIN_SUCCESS(20000, HttpStatus.OK, "소셜 로그인 성공"),
    ISSUE_ACCESS_TOKEN_SUCCESS(20001, HttpStatus.OK, "액세스 토큰 재발급 성공"),
    USER_DELETE_SUCCESS(20002, HttpStatus.OK, "회원 삭제 성공"),
    LOGOUT_SUCCESS(20003, HttpStatus.OK, "로그아웃 성공");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}