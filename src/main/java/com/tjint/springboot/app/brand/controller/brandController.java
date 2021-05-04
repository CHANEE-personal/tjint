package com.tjint.springboot.app.brand.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/business")
public class brandController {
    /**
     * <pre>
     * 1. MethodName : brandPage
     * 2. ClassName  : brandController.java
     * 3. Comment    : 프론트 > 브랜드 페이지
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value="/brandPage/{id}")
    public ModelAndView brandPage (HttpServletRequest request, @PathVariable String menuCd) throws Exception
    {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("/business/brandPage");
        mv.addObject("menuCd", menuCd);

        return mv;
    }
}
