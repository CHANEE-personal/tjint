package com.tjint.springboot.app.api.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.Map;

@Api(tags = "FRONT BUSINESS API")
@RequestMapping(value = "/api/business")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class FrontBusinessApi {
    @ApiOperation(value = "Front Mission 페이지", notes = "Front Mission 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/brandPage/{menuCd}")
    public JSONObject brandPage(@PathVariable("menuCd") Integer menuCd, HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        if(menuCd == 1) {
            jsonObject.put("brandPage",1);
        } else if(menuCd == 2) {
            jsonObject.put("brandPage",2);
        } else if(menuCd == 3) {
            jsonObject.put("brandPage",3);
        }

        return jsonObject;
    }
}