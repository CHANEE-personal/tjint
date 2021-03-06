package com.tjint.springboot.app.api.admin.login.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public interface AdminLoginApiService {
    /**
     * <pre>
     * 1. MethodName : getUserList
     * 2. ClassName  : AdminLoginApiService.java
     * 3. Comment    : 관리자 유저 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param userMap
     * @throws Exception
     */
    List<NewUserDTO> getUserList(ConcurrentHashMap<String, Object> userMap) throws Exception;

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
    String adminLogin(NewUserDTO newUserDTO, HttpServletRequest request, BindingResult bindingResult) throws Exception;

    /**
     * <pre>
     * 1. MethodName : insertUserToken
     * 2. ClassName  : AdminLoginApiService.java
     * 3. Comment    : 회원 로그인 후 토큰 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newUserDTO
     * @return result
     * @throws Exception
     */
    Integer insertUserToken(NewUserDTO newUserDTO) throws Exception;
}
