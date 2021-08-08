package com.tjint.springboot.app.admin.jwt;

import com.tjint.springboot.app.api.admin.login.service.impl.AdminLoginApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdminLoginApiMapper adminLoginApiMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        SecurityUser securityUser = null;
        try {
            securityUser = adminLoginApiMapper.getUserId(id);
            logger.info("securityUserId={}", securityUser.getUsername());
            logger.info("securityUserPass={}", securityUser.getPassword());
            logger.info("securityUserAuth={}", securityUser.getAuthorities());
            // 아이디 일치하는지 확인
            if(!"".equals(securityUser)) {
                return new User(securityUser.getUsername(),
                                securityUser.getPassword(),
                                AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
            }else {
                throw new UsernameNotFoundException("User not found with userid : " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return securityUser;
    }
}
