package com.tjint.springboot.app.admin.login.service.impl;

import com.tjint.springboot.common.UserInfoVo;
import com.tjint.springboot.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.tjint.springboot.app.admin.login.service.*;
import javax.servlet.http.HttpServletRequest;

@Service("AdminLoginService")
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginService{

    private final AdminLoginMapper adminDAO;

    public String adminLogin(final UserInfoVo searchVO, final HttpServletRequest request) throws Exception {
        final String db_pw = StringUtils.nullStrToStr(this.adminDAO.adminLogin(searchVO));
        String result = "";
        if (!db_pw.equals(searchVO.getPassword())) {
            result = "N";
        }
        else {
            final UserInfoVo userVO = selectAdminSeq(searchVO);
            request.getSession().setAttribute("adminVO", (Object)userVO);
            result = "Y";
        }
        return result;
    }

    public UserInfoVo selectAdminSeq(final UserInfoVo searchVO) throws Exception {
        return this.adminDAO.selectAdminSeq(searchVO);
    }

    public String selectJudgeType(final UserInfoVo searchVO) throws Exception {
        return this.adminDAO.selectJudgeType(searchVO);
    }
}
