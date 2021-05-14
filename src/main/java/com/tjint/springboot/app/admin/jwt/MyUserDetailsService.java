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
        if("admin03".equals(id)) {
           return new User("admin03", "$2a$10$yyrWhaXOXeCu/m05eWyI5OXZxqhTc.kRBqmD/Smg97c1MpXXcyeKy", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found with userid : " + id);
        }
    }
}
