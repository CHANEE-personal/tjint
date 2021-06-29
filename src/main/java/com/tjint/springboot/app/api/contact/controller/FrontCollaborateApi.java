package com.tjint.springboot.app.api.contact.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.Map;

@Api(tags = "FRONT CONTACT API")
@RequestMapping(value = "/api/contact")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class FrontCollaborateApi {
    @ApiOperation(value = "Front 협업 및 제휴 페이지", notes = "Front 협업 및 제휴 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/collaborate")
    public JSONObject collaborate(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

    @ApiOperation(value = "Front 윤리경영 페이지", notes = "Front 윤리경영 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/ethicsCommittee")
    public JSONObject ethicsCommittee(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

    @ApiOperation(value = "Front 오시는 길 페이지", notes = "Front 오시는 길 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/map")
    public JSONObject map(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }
}
