package com.pickple.server.api.moim.controller;

import com.pickple.server.api.moim.domain.enums.Category;
import com.pickple.server.api.moim.service.MoimService;
import com.pickple.server.global.response.ApiResponseDto;
import com.pickple.server.global.response.enums.SuccessCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MoimController {

    private final MoimService moimService;

    @GetMapping("/v1/moim/categories")
    public ApiResponseDto<List<String>> getAllCategories() {
        return ApiResponseDto.success(SuccessCode.ALL_CATEGORY_GET_SUCCESS, Category.getCategories());
    }
}