package com.pickple.server.api.user.controller;


import com.pickple.server.api.user.dto.AccessTokenGetSuccess;
import com.pickple.server.api.user.dto.LoginSuccessResponse;
import com.pickple.server.global.auth.client.dto.UserLoginRequest;
import com.pickple.server.global.response.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.security.Principal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "User", description = "User 관련 API")
public interface UserControllerDocs {
    @Operation(summary = "소셜 로그인")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "소셜 로그인이 완료되었습니다."),
                    @ApiResponse(responseCode = "400", description =
                            "1. 요청한 값이 유효하지 않습니다.\n" + "2. 인가 코드가 만료되었습니다.\n"),
                    @ApiResponse(responseCode = "500", description = "서버 내부 오류입니다.")
            }
    )
    ApiResponseDto<LoginSuccessResponse> login(
            @RequestParam final String authorizationCode,
            @RequestBody final UserLoginRequest loginRequest
    );

    @Operation(summary = "액세스 토큰 재발급")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "액세스 토큰 재발급이 완료되었습니다."),
                    @ApiResponse(responseCode = "401", description = "리프레시 토큰이 유효하지 않습니다."),
                    @ApiResponse(responseCode = "404", description = "해당 유저의 리프레시 토큰이 존재하지 않습니다."),
                    @ApiResponse(responseCode = "500", description = "서버 내부 오류입니다.")
            }
    )
    ApiResponseDto<AccessTokenGetSuccess> refreshToken(
            @RequestParam final String refreshToken
    );

    @Operation(summary = "회원 탈퇴")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "회원 삭제가 완료되었습니다."),
                    @ApiResponse(responseCode = "404", description =
                            "1. 해당 유저의 리프레시 토큰이 존재하지 않습니다.\n" +
                                    "2. 해당 유저는 존재하지 않습니다."
                    )
            }
    )
    ApiResponseDto deleteUser(
            final Principal principal
    );

    @Operation(summary = "로그아웃")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "로그아웃이 완료되었습니다."),
                    @ApiResponse(responseCode = "404", description = "해당 유저의 리프레시 토큰이 존재하지 않습니다.")
            }
    )
    ApiResponseDto logout(
            Principal principal
    );
}