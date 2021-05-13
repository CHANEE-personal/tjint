package com.tjint.springboot.app.api.brand.controller;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.ServerError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/brand")
@RestController
@RequiredArgsConstructor
@Api(tags = "브랜드관리관련 API")
public class adminBrandApi {
    private final AdminBrandApiService adminBrandApiService;

    @ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandList/{searchKeyword}")
    public List<BrandInfoVo> getBrandList(@PathVariable @ApiParam(value = "검색 키워드") String searchKeyword) throws Exception {

        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("searchKeyword", searchKeyword);

        List<BrandInfoVo> brandInfoList = this.adminBrandApiService.getBrandList(searchMap);

        return brandInfoList;
    }

    @ApiOperation(value = "브랜드 등록", notes = "브랜드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/addBrand")
    public void addBrand(BrandInfoVo brandInfoVo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String returnValue = "Y";
        try {
            returnValue = this.adminBrandApiService.addBrandInfo(brandInfoVo, request);
        } catch (Exception e) {
            returnValue = "fileError";
        }
        response.getWriter().print(returnValue);
    }

}
