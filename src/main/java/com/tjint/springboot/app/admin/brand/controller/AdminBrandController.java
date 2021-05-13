package com.tjint.springboot.app.admin.brand.controller;

import com.tjint.springboot.app.admin.brand.service.AdminBrandService;
import com.tjint.springboot.app.admin.brand.service.SnsInfoVo;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @package : com.tjint.springboot.app.admin.brand.controller
 * @method : AdminBrandController
 * @date : 12/05/2021 5:33 오후
 * @author : chanee
 * @version : 1.0.0
 * @modifyed : 브랜드관리
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/business")
public class AdminBrandController {
    private final AdminBrandService adminBrandService;

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : brandList
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드관리
     **/
    @GetMapping(value="/brandList")
    public String brandList(@ModelAttribute("BrandInfoVo") final BrandInfoVo searchVO, final HttpServletRequest request, final ModelMap model) throws Exception
    {
//        searchVO.setPageUnit(this.propertyService.getInt("pageUnit"));
//        searchVO.setPageSize(this.propertyService.getInt("pageSize"));
//        final PaginationInfo paginationInfo = new PaginationInfo();
//        paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
//        paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
//        paginationInfo.setPageSize(searchVO.getPageSize());
//        searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//        searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//        searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        final List<BrandInfoVo> brandList = this.adminBrandService.getBrandList(searchVO);
        final CodeVo codeVo = new CodeVo();
//        codeVo.setVisible("Y");
        codeVo.setParentCd("ct000");
        final List<SnsInfoVo> codeList = this.adminBrandService.getCodeList(codeVo);
//        final int totCnt = this.adminBrandService.getBrandListCnt(searchVO);
//        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("brandList", brandList);
//        model.addAttribute("resultCnt", totCnt);
        model.addAttribute("searchVO", searchVO);
        model.addAttribute("codeList", codeList);
        return "admin/brand/brandList";
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : categoryList
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 분야관리
     **/
    @GetMapping(value="/categoryList")
    public String categoryList(final HttpServletRequest request, final ModelMap model) throws Exception
    {
        String result = "";
        return result;
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : snsList
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : SNS관
     **/
    @GetMapping(value="/snsList")
    public String snsList(HttpServletRequest request, ModelMap model) throws Exception
    {
        String result = "";
        return result;
    }
}
