package com.tjint.springboot.app.api.front.business.controller;

import com.tjint.springboot.app.api.front.business.service.FrontBusinessApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.ServerError;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Api(tags = "FRONT BUSINESS API")
@RequestMapping(value = "/api/business")
@RestController
@RequiredArgsConstructor
public class FrontBusinessApi {

    private final FrontBusinessApiService frontBusinessApiService;

    /**
     * <pre>
     * 1. MethodName : brandPage
     * 2. ClassName  : FrontBusinessApi.java
     * 3. Comment    : brandPage
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param  menuCd
     * @return brandMap
     * @throws Exception
     */
    @ApiOperation(value = "Front Mission 페이지", notes = "Front Mission 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/{menuCd}")
    public ConcurrentHashMap<String, Object> brandPage(@PathVariable("menuCd") Integer menuCd) throws Exception {

        ConcurrentHashMap<String, Object> brandMap = new ConcurrentHashMap<>();

        brandMap.put("menuCd", menuCd);

        ConcurrentHashMap resultMap = this.frontBusinessApiService.getBrandList(brandMap);

        return resultMap;
    }
}
