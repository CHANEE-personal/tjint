package com.tjint.springboot.app.api.admin.service;

import com.tjint.springboot.common.UserInfoVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface AdminLoginApiService {
    public List<UserInfoVo> getUserList() throws Exception;

    /** 아이디 조회 **/
    public String getUserId(String id) throws Exception;

    /** 패스워드 조회 **/
    public String adminLogin(String id) throws Exception;

    /** 회원 로그인 처리 **/
    String adminLogin(final UserInfoVo p0, final HttpServletRequest p1) throws Exception;
}
