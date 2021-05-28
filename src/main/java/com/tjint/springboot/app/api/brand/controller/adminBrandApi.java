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
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiIgnore
    @ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandList")
    public List<BrandInfoVo> getBrandSearchList(Page page) throws Exception {

        Map<String, Object> searchMap = new HashMap<>();

        Integer pageCnt = StringUtil.getInt(page.getPage(),1);
        Integer pageSize = StringUtil.getInt(page.getSize(),10);
        page.setPage(pageCnt);
        page.setSize(pageSize);
        searchMap.put("startPage", page.getStartPage());

        Integer brandListCnt = this.adminBrandApiService.getBrandListCnt(searchMap);
        List<BrandInfoVo> brandInfoList = null;

        if(brandListCnt > 0) {
            brandInfoList = this.adminBrandApiService.getBrandList(searchMap);
        }

        return brandInfoList;
    }

    @ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandList/{searchKeyword}")
    public List<BrandInfoVo> getBrandSearchList(@PathVariable("searchKeyword") String searchKeyword, Page page) throws Exception {

        Map<String, Object> searchMap = new HashMap<>();

        searchMap.put("searchKeyword", StringUtil.getString(searchKeyword,""));
        searchMap.put("startPage", page.getStartPage());

        Integer brandListCnt = this.adminBrandApiService.getBrandListCnt(searchMap);
        List<BrandInfoVo> brandInfoList = null;

        if(brandListCnt > 0) {
            brandInfoList = this.adminBrandApiService.getBrandList(searchMap);
        }

        return brandInfoList;
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : brandInfo
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드 상세
     **/
    @ApiOperation(value = "브랜드 상세", notes = "브랜드를 상세페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandInfo/{brandSeq}")
    public Map<String, Object> brandInfo(@RequestParam(value = "브랜드 IDX", required = false) Integer brandSeq) throws Exception {

        BrandInfoVo brandInfoVo = new BrandInfoVo();
        brandInfoVo.setBrandSeq(brandSeq);
        Map<String, Object> brandMap = this.adminBrandApiService.getBrandInfo(brandInfoVo);

        return brandMap;
    }

    @ApiOperation(value = "브랜드 등록", notes = "브랜드를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @PostMapping(value = "/addBrand")
    public void addBrand(BrandInfoVo brandInfoVo) throws Exception {
        this.adminBrandApiService.addBrand(brandInfoVo);
    }

    @ApiOperation(value = "브랜드 수정", notes = "브랜드를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "브랜드 수정성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })

    @PutMapping(value = "/updateBrand/{brandSeq}")
    public void updateBrand(BrandInfoVo brandInfoVo) throws Exception {
        this.adminBrandApiService.modifyBrand(brandInfoVo);
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
