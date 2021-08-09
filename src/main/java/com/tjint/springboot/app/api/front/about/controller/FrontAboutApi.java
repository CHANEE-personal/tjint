package com.tjint.springboot.app.api.front.about.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.ServerError;
import java.util.Map;

@Api(tags = "FRONT ABOUT API")
@RequestMapping(value = "/api/about")
@RestController
@RequiredArgsConstructor
public class FrontAboutApi {
    /**
     * <pre>
     * 1. MethodName : mission
     * 2. ClassName  : FrontAboutApi.java
     * 3. Comment    : misson 페이지
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "Front Mission 페이지", notes = "Front Mission 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/mission")
    public String mission() throws Exception {
        return "mission";
    }

    /**
     * <pre>
     * 1. MethodName : ceo
     * 2. ClassName  : FrontAboutApi.java
     * 3. Comment    : ceo 페이지
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "Front Ceo 페이지", notes = "Front Ceo 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/ceo")
    public String ceo() throws Exception {
        return "ceo";
    }

    /**
     * <pre>
     * 1. MethodName : corpHistory
     * 2. ClassName  : FrontAboutApi.java
     * 3. Comment    : history 페이지
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "Front History 페이지", notes = "Front History 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/corp-history")
    public String corpHistory() throws Exception {
        return "corp-history";
    }

    /**
     * <pre>
     * 1. MethodName : ci
     * 2. ClassName  : FrontAboutApi.java
     * 3. Comment    : ci 페이지
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "Front Ci 페이지", notes = "Front Ci 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/ci")
    public String ci() throws Exception {
        return "ci";
    }

}
