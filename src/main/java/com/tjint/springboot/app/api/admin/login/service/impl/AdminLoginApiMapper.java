package com.tjint.springboot.app.api.admin.login.service.impl;

import com.tjint.springboot.app.admin.jwt.SecurityUser;
import com.tjint.springboot.app.api.admin.login.service.NewUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Mapper
public interface AdminLoginApiMapper {
    /**
     * <pre>
     * 1. MethodName : getUserList
     * 2. ClassName  : AdminLoginApiMapper.java
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
     * 1. MethodName : getUserId
     * 2. ClassName  : AdminLoginApiMapper.java
     * 3. Comment    : 관리자 유저 아이디 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param  id
     * @throws Exception
     */
    SecurityUser getUserId(String id) throws Exception;


    /**
     * <pre>
     * 1. MethodName : adminLogin
     * 2. ClassName  : AdminLoginApiMapper.java
     * 3. Comment    : 관리자 로그인 처리
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param  newUserDTO
     * @throws Exception
     */
    String adminLogin(NewUserDTO newUserDTO) throws Exception;

    NewUserDTO selectAdminSeq(NewUserDTO newUserDTO) throws Exception;
}
