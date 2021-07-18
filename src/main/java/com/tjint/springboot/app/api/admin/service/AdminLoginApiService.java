package com.tjint.springboot.app.api.admin.service;

import com.tjint.springboot.common.UserInfoVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public interface AdminLoginApiService {
    /** 회원 조회 **/
    public List<UserInfoVo> getUserList(Map<String, Object> userMap) throws Exception;

    /** 아이디 조회 **/
    public String getUserId(String id) throws Exception;

    /** 패스워드 조회 **/
    public String adminLogin(String id) throws Exception;

    /**
     * <pre>
     * 1. MethodName : adminLogin
     * 2. ClassName  : AdminLoginApiService.java
     * 3. Comment    : 회원 로그인 처리
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newUserDTO
     * @param request
     * @return result
     * @throws Exception
     */
    String adminLogin(NewUserDTO newUserDTO, HttpServletRequest request) throws Exception;
}
