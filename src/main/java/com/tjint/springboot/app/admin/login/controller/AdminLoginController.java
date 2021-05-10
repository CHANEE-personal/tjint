package com.tjint.springboot.app.admin.login.controller;

import com.tjint.springboot.app.admin.login.service.AdminLoginService;
import com.tjint.springboot.common.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminLoginController {

    private final AdminLoginService adminLoginService;

    @GetMapping(value="/login")
    public String adminLoginForm(final Model model, final HttpServletRequest request) {
        final UserInfoVo loginVO = (UserInfoVo)request.getSession().getAttribute("adminVO");
        if (loginVO != null) {
            return "redirect:/business/brandList";
        }
        return "admin/login/adminLogin";
    }

    @PostMapping(value = "/login/adminLogin")
    public void adminLogin(final UserInfoVo userInfoVo, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final String resultValue = adminLoginService.adminLogin(userInfoVo, request);
        response.getWriter().print(resultValue);
    }

    @GetMapping(value = "/logout")
    public String adminLogOut(final HttpServletRequest request) throws Exception {
        request.getSession().invalidate();
        return "redirect:/admin/login";
    }
}
