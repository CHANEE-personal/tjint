package com.tjint.springboot.app.api.admin.service.impl;

import com.tjint.springboot.common.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminLoginApiMapper {
    List<UserInfoVo> getUserList() throws Exception;

    String getUserId(String id) throws Exception;

    String adminLogin(String id) throws Exception;

    String adminLogin(final UserInfoVo p0) throws Exception;

    UserInfoVo selectAdminSeq(final UserInfoVo p0) throws Exception;
}
