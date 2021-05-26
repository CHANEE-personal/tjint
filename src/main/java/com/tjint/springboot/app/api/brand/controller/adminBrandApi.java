package com.tjint.springboot.app.api.brand.controller;

import com.tjint.springboot.app.admin.jwt.JwtDecoder;
import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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
    private final JwtUtil jwtUtil;
    private final JwtDecoder jwtDecoder;

    @ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandList/{searchKeyword}")
    public List<BrandInfoVo> getBrandSearchList(@RequestParam(value = "검색 키워드", required = false) String searchKeyword, Page page) throws Exception {

        Map<String, Object> searchMap = new HashMap<>();

        searchMap.put("searchKeyword", StringUtil.getString(searchKeyword,""));
        searchMap.put("page", page.getPage());
        searchMap.put("size", page.getSize());

        List<BrandInfoVo> brandInfoList = this.adminBrandApiService.getBrandList(searchMap);

        return brandInfoList;
    }

    @ApiOperation(value = "브랜드 등록", notes = "브랜드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @PostMapping(value = "/addBrand")
    public void addBrand(@RequestParam(value = "브랜드명") String brandName,
                         @RequestParam(value = "분야") String categoryCd,
                         @RequestParam(value = "브랜드소개") String brandDescription,
                         @RequestParam(value = "노출여부") String visible) throws Exception {

        Map<String, Object> brandMap = new HashMap<String, Object>();
        brandMap.put("brandName", brandName);
        brandMap.put("categoryCd", categoryCd);
        brandMap.put("brandDescription", brandDescription);
        brandMap.put("visible", visible);
        brandMap.put("updater", 1);

        this.adminBrandApiService.addBrandInfo(brandMap);

    }

    @ApiOperation(value = "브랜드 수정", notes = "브랜드를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 수정성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @PutMapping(value = "/updateBrand/{brandSeq}")
    public void updateBrand(@RequestParam(value = "브랜드명") String brandName,
                            @RequestParam(value = "분야") String categoryCd,
                            @RequestParam(value = "브랜드소개") String brandDescription,
                            @RequestParam(value = "노출여부") String visible) throws Exception {

    }
    @ApiOperation(value = "브랜드 삭제", notes = "브랜드를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 삭제성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })


    @DeleteMapping(value = "/deleteBrand/{brandSeq}")
    public void deleteBrand(@PathVariable @ApiParam(value = "브랜드코드", required = true) Integer brandSeq) throws Exception {

        BrandInfoVo brandInfoVo = new BrandInfoVo();
        brandInfoVo.setVisible("D");
        brandInfoVo.setBrandSeq(brandSeq);

        this.adminBrandApiService.modifyBrand(brandInfoVo);

    }

}
