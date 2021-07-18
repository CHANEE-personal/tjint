package com.tjint.springboot.app.api.admin.service.impl;

import com.tjint.springboot.app.api.admin.service.AdminLoginApiService;
import com.tjint.springboot.app.api.admin.service.NewUserDTO;
import com.tjint.springboot.common.UserInfoVo;
import com.tjint.springboot.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("AdminLoginApiService")
@RequiredArgsConstructor
public class AdminLoginApiServiceImpl implements AdminLoginApiService {

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

    /**
     * <pre>
     * 1. MethodName : adminLogin
     * 2. ClassName  : AdminLoginApiServiceImpl.java
     * 3. Comment    : 회원 로그인 처리
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newUserDTO
     * @param request
     * @return result
     * @throws Exception
     */
    public String adminLogin(NewUserDTO newUserDTO, HttpServletRequest request) throws Exception {
        final String db_pw = StringUtils.nullStrToStr(this.adminLoginApiMapper.adminLogin(newUserDTO));

        String result = "";
        if (passwordEncoder.matches(newUserDTO.getPassword(), db_pw)) {
            result = "Y";
            NewUserDTO newUserDTO1 = selectAdminSeq(newUserDTO);
            request.getSession().setAttribute("adminVO", newUserDTO1);
        }
        else {
            result = "N";
        }
        return result;
    }

    public NewUserDTO selectAdminSeq(NewUserDTO newUserDTO) throws Exception {
        return this.adminLoginApiMapper.selectAdminSeq(newUserDTO);
    }
}
