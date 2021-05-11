package com.tjint.springboot.app.admin.login.service.impl;

import com.tjint.springboot.common.UserInfoVo;
import com.tjint.springboot.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.tjint.springboot.app.admin.login.service.AdminLoginService;
import javax.servlet.http.HttpServletRequest;

@Service("AdminLoginService")
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginService{

    private final AdminLoginMapper adminDAO;

    public String adminLogin(final UserInfoVo userInfoVo, final HttpServletRequest request) throws Exception {
        final String db_pw = StringUtils.nullStrToStr(this.adminDAO.adminLogin(userInfoVo));
        String result = "";
        if (!db_pw.equals(userInfoVo.getPassword())) {
            result = "N";
        }
        else {
            final UserInfoVo userVO = selectAdminSeq(userInfoVo);
            request.getSession().setAttribute("adminVO", userVO);
            result = "Y";
        }
        return result;
    }

    public UserInfoVo selectAdminSeq(final UserInfoVo userInfoVo) throws Exception {
        return this.adminDAO.selectAdminSeq(userInfoVo);
    }

}
