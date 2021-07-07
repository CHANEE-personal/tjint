package com.tjint.springboot.app.api.business.controller;

import com.tjint.springboot.app.api.business.service.FrontBusinessApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.ServerError;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "FRONT BUSINESS API")
@RequestMapping(value = "/api/business")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class FrontBusinessApi {

    private final FrontBusinessApiService frontBusinessApiService;

    @ApiOperation(value = "Front Mission 페이지", notes = "Front Mission 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandPage/{menuCd}")
    @ResponseBody
    public Map<String, Object> brandPage(@PathVariable("menuCd") Integer menuCd) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        Map<String, Object> brandMap = new HashMap<>();

        brandMap.put("menuCd", menuCd);

        resultMap = this.frontBusinessApiService.getBrandList(brandMap);

        return resultMap;
    }
}
