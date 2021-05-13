package com.tjint.springboot.app.api.brand.controller;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping(value = "/brandList")
    public List<BrandInfoVo> getBrandList() throws Exception {

        Map<String, Object> searchMap = new HashMap<>();

        List<BrandInfoVo> brandInfoList = this.adminBrandApiService.getBrandList(searchMap);

        return brandInfoList;
    }

    @ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandList/{searchKeyword}")
    public List<BrandInfoVo> getBrandSearchList(@PathVariable @ApiParam(value = "검색 키워드") String searchKeyword) throws Exception {

        Map<String, Object> searchMap = new HashMap<>();

        searchMap.put("searchKeyword", StringUtil.getString(searchKeyword,""));

        List<BrandInfoVo> brandInfoList = this.adminBrandApiService.getBrandList(searchMap);

        return brandInfoList;
    }

    @ApiOperation(value = "브랜드 등록", notes = "브랜드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @PutMapping(value = "/addBrand")
    public void addBrand(@PathVariable @ApiParam(value = "브랜드명") String brandName,
                         @PathVariable @ApiParam(value = "분야") String categoryCd,
                         @PathVariable @ApiParam(value = "브랜드소개") String brandDescription,
                         @PathVariable @ApiParam(value = "노출여부") String visible,
                         HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> brandMap = new HashMap<>();
        brandMap.put("brand_name", brandName);
        brandMap.put("categoryCd", categoryCd);
        brandMap.put("brandDescription", brandDescription);
        brandMap.put("visible", visible);

        String returnValue = "Y";
        try {
            returnValue = this.adminBrandApiService.addBrandInfo(brandMap, request);
        } catch (Exception e) {
            returnValue = "fileError";
        }
        response.getWriter().print(returnValue);
    }

    @ApiOperation(value = "브랜드 삭제", notes = "브랜드를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @DeleteMapping(value = "/deleteBrand/{brandSeq}")
    public void deleteBrand(@PathVariable @ApiParam(value = "브랜드코드", required = true) Integer brandSeq,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {

        BrandInfoVo brandInfoVo = new BrandInfoVo();
        brandInfoVo.setVisible("D");
        brandInfoVo.setBrandSeq(brandSeq);

        this.adminBrandApiService.modifyBrand(brandInfoVo);

        response.getWriter().print("Y");
    }

}
