package com.tjint.springboot.app.api.admin.controller;

import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.common.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/auth")
@RestController
@RequiredArgsConstructor
@Api(tags = "회원관련 API")
public class adminLoginApi {

    private final AdminLoginApiService adminLoginApiService;

    @ApiOperation(value = "회원 조회", notes = "회원을 조회한다.")
    @GetMapping(value = "/adminUser")
    public List<UserInfoVo> getUserList() throws Exception {
        List<UserInfoVo> userInfoList = this.adminLoginApiService.getUserList();

        return userInfoList;
    }
}
