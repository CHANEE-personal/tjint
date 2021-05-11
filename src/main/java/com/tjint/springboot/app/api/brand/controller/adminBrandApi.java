package com.tjint.springboot.app.api.brand.controller;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/brand")
@RestController
@RequiredArgsConstructor
@Api(tags = "브랜드관리관련 API")
public class adminBrandApi {
    private final AdminBrandApiService adminBrandApiService;

    @ApiOperation(value = "브랜드 조회", notes = "회원을 조회한다.")
    @GetMapping(value = "/brandList")
    public List<BrandInfoVo> getBrandList() throws Exception {
        List<BrandInfoVo> brandInfoList = this.adminBrandApiService.getBrandList();

        return brandInfoList;
    }
}
