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
    List<NewUserDTO> getUserList(ConcurrentHashMap<String, Object> userMap) throws Exception;

    SecurityUser getUserId(String id) throws Exception;

    String adminLogin(String id) throws Exception;

    String adminLogin(NewUserDTO newUserDTO) throws Exception;

    NewUserDTO selectAdminSeq(NewUserDTO newUserDTO) throws Exception;
}
