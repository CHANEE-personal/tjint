package com.tjint.springboot.app.admin.jwt;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Component
public class JwtDecoder {

    private JwtUtil jwtUtil;

    public JwtDecoder(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String jwtDecoder(ServletRequest servletRequest) throws Exception {

        String authorizationHeader = jwtUtil.resolveToken((HttpServletRequest) servletRequest);

        String token = "";
        String userId = "";

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            userId = jwtUtil.extractUserName(token);
        }

        return userId;
    }
}
