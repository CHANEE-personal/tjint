package com.tjint.springboot.app.configuration;

import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws UserException {
        final String token = request.getHeader("authentication");
        log.info("preHandle: " + token);
        if ("".equals(StringUtil.getString(jwtUtil.resolveToken(request),""))) {

        }
        return true;
    }
}
