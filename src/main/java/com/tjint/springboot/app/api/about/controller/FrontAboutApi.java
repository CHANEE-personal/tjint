package com.tjint.springboot.app.api.about.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.Map;

@Api(tags = "FRONT ABOUT API")
@RequestMapping(value = "/api/about")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class FrontAboutApi {
    @ApiOperation(value = "Front Mission 페이지", notes = "Front Mission 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/mission")
    public JSONObject mission(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

    @ApiOperation(value = "Front Ceo 페이지", notes = "Front Ceo 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/ceo")
    public JSONObject ceo(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

    @ApiOperation(value = "Front History 페이지", notes = "Front History 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/corpHistory")
    public JSONObject corpHistory(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

    @ApiOperation(value = "Front Ci 페이지", notes = "Front Ci 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/ci")
    public JSONObject ci(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

}
