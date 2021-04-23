package com.tjint.springboot.app.about.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/about")
public class aboutController {
    /**
     * <pre>
     * 1. MethodName : mission
     * 2. ClassName  : aboutController.java
     * 3. Comment    : 프론트 > about
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value="/mission")
    public ModelAndView mission (HttpServletRequest request) throws Exception
    {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/about/mission");

        return mv;
    }

    /**
     * <pre>
     * 1. MethodName : ceo
     * 2. ClassName  : aboutController.java
     * 3. Comment    : 프론트 > ceo page
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value="/ceo")
    public ModelAndView ceo (HttpServletRequest request) throws Exception
    {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/about/ceo");

        return mv;
    }
}
