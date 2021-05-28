package com.tjint.springboot.app.admin.login.service.impl;

import com.tjint.springboot.app.admin.login.service.AdminLoginService;
import com.tjint.springboot.app.api.admin.service.impl.AdminLoginApiMapper;
import com.tjint.springboot.common.UserInfoVo;
import com.tjint.springboot.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("AdminLoginService")
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginService{

    private final AdminLoginApiMapper adminLoginApiMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserInfoVo> getUserList(Map<String, Object> userMap) throws Exception {
        return adminLoginApiMapper.getUserList(userMap);
    }

    public String getUserId(String id) throws Exception {
        return adminLoginApiMapper.getUserId(id);
    }

    public String adminLogin(String id) throws Exception {
        return adminLoginApiMapper.adminLogin(id);
    }

    /** 회원 로그인 처리 **/
    public String adminLogin(final UserInfoVo userInfoVo, final HttpServletRequest request) throws Exception {
        final String db_pw = StringUtils.nullStrToStr(this.adminLoginApiMapper.adminLogin(userInfoVo));

        String result = "";
        if (passwordEncoder.matches(userInfoVo.getPassword(), db_pw)) {
            result = "Y";
            final UserInfoVo userVO = selectAdminSeq(userInfoVo);
            request.getSession().setAttribute("adminVO", userVO);
        }
        else {
            result = "N";
        }
        return result;
    }

    public UserInfoVo selectAdminSeq(final UserInfoVo userInfoVo) throws Exception {
        return this.adminLoginApiMapper.selectAdminSeq(userInfoVo);
    }

}
