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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
    private final PasswordEncoder passwordEncoder;

//    public adminLoginApi(AuthenticationManager authenticationManager,
//                         MyUserDetailsService userDetailsService,
//                         JwtUtil jwtTokenUtil,
//                         AdminLoginApiService adminLoginApiService,
//                         PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.adminLoginApiService = adminLoginApiService;
//        this.passwordEncoder = passwordEncoder;
//    }


    @ApiOperation(value = "회원 조회", notes = "회원을 조회한다.")
    @PostMapping(value = "/adminUser")
    public List<UserInfoVo> getUserList() throws Exception {
        List<UserInfoVo> userInfoList = this.adminLoginApiService.getUserList();

        return userInfoList;
    }

    @ApiOperation(value = "JWT 토근 발급", notes = "JWT 토근 발급")
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            if(passwordEncoder.matches(authenticationRequest.getPassword(),passwordEncoder.encode(authenticationRequest.getPassword()))) {
//                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getId(),
//                        passwordEncoder.encode(authenticationRequest.getPassword())));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect userid or password", e);
//        }


//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getId());
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
        System.out.println("===userId===");
        System.out.println(authenticationRequest.getId());
        System.out.println(passwordEncoder.encode(authenticationRequest.getPassword()));
        authenticate(authenticationRequest.getId(), passwordEncoder.encode(authenticationRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getId());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String id, String password) throws Exception {
        try {
            System.out.println("===UserName===");
            System.out.println(new UsernamePasswordAuthenticationToken(id,password));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(id);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails,password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
