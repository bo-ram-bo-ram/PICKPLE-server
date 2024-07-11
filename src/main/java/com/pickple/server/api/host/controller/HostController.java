package com.pickple.server.api.host.controller;

import com.pickple.server.api.host.service.HostQueryService;
import com.pickple.server.global.common.annotation.HostId;
import com.pickple.server.global.response.ApiResponseDto;
import com.pickple.server.global.response.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HostController {

    private final HostQueryService hostQueryService;

    @GetMapping("/v1/host")
    public ApiResponseDto getHost(@HostId Long hostId) {
        return ApiResponseDto.success(SuccessCode.HOST_DETAIL_GET_SUCCESS, hostQueryService.getHost(hostId));
    }
}