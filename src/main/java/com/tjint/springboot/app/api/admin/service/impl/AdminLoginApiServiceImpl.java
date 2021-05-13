package com.tjint.springboot.app.api.admin.service.impl;

import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.common.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminLoginApiService")
@RequiredArgsConstructor
public class AdminLoginApiServiceImpl implements AdminLoginApiService {

    private final AdminLoginApiMapper adminLoginApiMapper;

    public List<UserInfoVo> getUserList() throws Exception {
        return adminLoginApiMapper.getUserList();
    }

    public String getUserId(String id) throws Exception {
        return adminLoginApiMapper.getUserId(id);
    }

    public String adminLogin(String id) throws Exception {
        return adminLoginApiMapper.adminLogin(id);
    }
}
