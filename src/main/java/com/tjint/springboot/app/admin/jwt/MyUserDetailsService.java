package com.tjint.springboot.app.admin.jwt;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        // 아이디 일치하는지 확인
        if("admin01".equals(id)) {
           return new User("admin01", "84b22888fe565d41c7a296b12e2518bf5633bf307a2cce85d27ccf935d49d69b", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found with userid : " + id);
        }
    }
}
