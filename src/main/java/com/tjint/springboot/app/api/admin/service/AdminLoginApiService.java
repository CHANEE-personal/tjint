package com.tjint.springboot.app.api.admin.service;

import com.tjint.springboot.common.UserInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminLoginApiService {
    public List<UserInfoVo> getUserList() throws Exception;
}
