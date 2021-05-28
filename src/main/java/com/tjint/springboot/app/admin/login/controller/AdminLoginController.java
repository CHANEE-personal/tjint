package com.tjint.springboot.app.admin.login.controller;

import com.tjint.springboot.app.admin.jwt.AuthenticationRequest;
import com.tjint.springboot.app.admin.jwt.AuthenticationResponse;
import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.app.admin.jwt.MyUserDetailsService;
import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.common.UserInfoVo;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminLoginController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;
    private final AdminLoginApiService adminLoginService;

    @PostMapping(value = "/adminLogin")
    public JSONObject adminLogin(@RequestBody AuthenticationRequest authenticationRequest, final HttpServletRequest request, final HttpServletResponse response) throws Exception {

        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserId(authenticationRequest.getUserId());
        userInfoVo.setPassword(authenticationRequest.getPassword());

        final String resultValue = adminLoginService.adminLogin(userInfoVo, request);

        JSONObject jsonObject = new JSONObject();
        if("Y".equals(resultValue)) {
            jsonObject.put("loginYn", resultValue);
            jsonObject.put("userId", userInfoVo.getUserId());
            jsonObject.put("token", createAuthenticationToken(authenticationRequest));
        }

        return jsonObject;
    }

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
