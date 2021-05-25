package com.tjint.springboot.app.api.admin.controller;

import com.tjint.springboot.app.admin.jwt.AuthenticationRequest;
import com.tjint.springboot.app.admin.jwt.AuthenticationResponse;
import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.app.admin.jwt.MyUserDetailsService;
import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.common.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "회원관련 API")
@RequestMapping(value = "/api/auth")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class adminLoginApi {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;
    private final AdminLoginApiService adminLoginApiService;

    @ApiOperation(value = "회원 조회", notes = "회원을 조회한다.")
    @PostMapping(value = "/adminUser")
    public List<UserInfoVo> getUserList() throws Exception {
        List<UserInfoVo> userInfoList = this.adminLoginApiService.getUserList();

        return userInfoList;
    }

    @ApiOperation(value = "회원 로그인 처리", notes = "회원 로그인을 처리한다.")
    @PostMapping(value = "/adminLogin")
    public JSONObject adminLogin(@RequestParam(value = "아이디") String userId
                                , @RequestParam(value = "패스워드") @ApiParam(type="string", format="password") String password, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();

        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserId(userId);
        userInfoVo.setPassword(password);
        final String resultValue = adminLoginApiService.adminLogin(userInfoVo, request);

        authenticationRequest.setUserId(userId);
        authenticationRequest.setPassword(password);

        JSONObject jsonObject = new JSONObject();
        if("Y".equals(resultValue)) {
            jsonObject.put("loginYn", resultValue);
            jsonObject.put("userId", userInfoVo.getUserId());
            jsonObject.put("token", createAuthenticationToken(authenticationRequest));
        }

        return jsonObject;
    }

    @ApiIgnore
    @ApiOperation(value = "JWT 토근 발급", notes = "JWT 토근 발급")
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

//        authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserId());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String id, String password) throws Exception {
        try {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(id);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id,password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
