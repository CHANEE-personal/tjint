package com.tjint.springboot.app.api.admin.controller;

import com.tjint.springboot.app.admin.jwt.AuthenticationRequest;
import com.tjint.springboot.app.admin.jwt.AuthenticationResponse;
import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.app.admin.jwt.MyUserDetailsService;
import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.common.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/auth")
@RestController
@RequiredArgsConstructor
@Api(tags = {"1","회원관련 API"})
public class adminLoginApi {

    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;
    private final AdminLoginApiService adminLoginApiService;

    @ApiOperation(value = "회원 조회", notes = "회원을 조회한다.")
    @PostMapping(value = "/adminUser")
    public List<UserInfoVo> getUserList() throws Exception {
        List<UserInfoVo> userInfoList = this.adminLoginApiService.getUserList();

        return userInfoList;
    }

//    @ApiOperation(value = "JWT 토근 발급", notes = "JWT 토근 발급")
//    @PostMapping(value = "/adminLogin")
//    public String adminLogin(@ApiParam(value = "ID", required = true) String id,
//                             @ApiParam(value = "PASSWORD", required = true) String password) throws Exception {
//
//        authenticationRequest.setId(id);
//        authenticationRequest.setPassword(password);
//
//        String result = StringUtil.getString(authentication.createAuthenticationToken(authenticationRequest),"");
//        return result;
//    }

    @ApiOperation(value = "JWT 토근 발급", notes = "JWT 토근 발급")
    @PostMapping(value = "/authenticate")
    @ResponseBody
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect userid or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getId());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
