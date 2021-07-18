package com.tjint.springboot.app.api.admin.controller;

import com.tjint.springboot.app.admin.jwt.AuthenticationRequest;
import com.tjint.springboot.app.admin.jwt.AuthenticationResponse;
import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.app.admin.jwt.MyUserDetailsService;
import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.app.api.admin.service.NewUserDTO;
import com.tjint.springboot.common.UserInfoVo;
import com.tjint.springboot.common.paging.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.ServerError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @PostMapping(value = "/adminUser")
    public List<UserInfoVo> getUserList(Page page) throws Exception {

        // 페이지 정보
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("page", page.getPage());
        userMap.put("size", page.getSize());

        List<UserInfoVo> userInfoList = this.adminLoginApiService.getUserList(userMap);

        return userInfoList;
    }

    @ApiOperation(value = "회원 로그인 처리", notes = "회원 로그인을 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @PostMapping(value = "/adminLogin")
    @ResponseBody
    public JSONObject adminLogin(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request, final HttpServletResponse response) throws Exception {

        NewUserDTO newUserDTO = new NewUserDTO();

        newUserDTO.setUserId(authenticationRequest.getUserId());
        newUserDTO.setPassword(authenticationRequest.getPassword());

        String resultValue = adminLoginApiService.adminLogin(newUserDTO, request);

        JSONObject jsonObject = new JSONObject();
        if("Y".equals(resultValue)) {
            jsonObject.put("loginYn", resultValue);
            jsonObject.put("userId", newUserDTO.getUserId());
            jsonObject.put("token", createAuthenticationToken(authenticationRequest));
        }

        return jsonObject;
    }

    @ApiIgnore
    @ApiOperation(value = "JWT 토근 발급", notes = "JWT 토근 발급")
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        // id, password 인증
        authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());

        // 사용자 정보 조회 후 token 생성
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserId());
        String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String id, String password) throws Exception {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(id, password);
            if(request.getName().equals(request.getCredentials())) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getName(), request.getCredentials()));
            }
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
