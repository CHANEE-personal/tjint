package com.tjint.springboot.app.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/main")
public class mainController {

    /**
     * <pre>
     * 1. MethodName : mainPage
     * 2. ClassName  : mainController.java
     * 3. Comment    : 프론트 > 메인화면
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value="/mainPage")
    public ModelAndView mainPage (HttpServletRequest request) throws Exception
    {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/main/mainPage");

        return mv;
    }
}
