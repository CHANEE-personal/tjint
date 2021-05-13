package com.tjint.springboot.app.admin.jwt;

import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminLoginApiService adminLoginApiService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        // 아이디 조회
        String userId = StringUtil.getString(adminLoginApiService.getUserId(id),"");

        // 아이디 일치하는지 확인
        if(userId.equals(id)) {
           return new User(userId, "84b22888fe565d41c7a296b12e2518bf5633bf307a2cce85d27ccf935d49d69b", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found with userid : " + id);
        }
    }
}
