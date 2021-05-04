package com.tjint.springboot.app.admin.login.service.impl;

import com.tjint.springboot.common.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminLoginMapper {
    String adminLogin(final UserInfoVo p0) throws Exception;

    UserInfoVo selectAdminSeq(final UserInfoVo p0) throws Exception;

    String selectJudgeType(final UserInfoVo p0) throws Exception;
}
