package com.tjint.springboot.app.admin.login.service;

import com.tjint.springboot.common.UserInfoVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface AdminLoginService {
    String adminLogin(final UserInfoVo p0, final HttpServletRequest p1) throws Exception;

    UserInfoVo selectAdminSeq(final UserInfoVo p0) throws Exception;

}
