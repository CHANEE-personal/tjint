package com.tjint.springboot.app.admin.brand.controller;

import com.tjint.springboot.app.admin.brand.service.AdminBrandService;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.EgovProperties;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminBrandController {
    private final AdminBrandService adminBrandService;
    private final EgovProperties propertyService;

    @GetMapping(value="/business/brandList")
    public String brandList(@ModelAttribute("BrandInfoVo") final BrandInfoVo searchVO, final HttpServletRequest request, final ModelMap model) throws Exception
    {
        searchVO.setPageUnit(this.propertyService.getInt("pageUnit"));
        searchVO.setPageSize(this.propertyService.getInt("pageSize"));
        final PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
        paginationInfo.setPageSize(searchVO.getPageSize());
        searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
        searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        final List<BrandInfoVo> brandList = (List<BrandInfoVo>)this.adminBrandService.getBrandList(searchVO);
        final CodeVo codeVo = new CodeVo();
        codeVo.setVisible("Y");
        codeVo.setParentCd("ct000");
        final List<SnsInfoVo> codeList = (List<SnsInfoVo>)this.adminBrandService.getCodeList(codeVo);
        final int totCnt = this.adminBrandService.getBrandListCnt(searchVO);
        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("brandList", (Object)brandList);
        model.addAttribute("resultCnt", (Object)totCnt);
        model.addAttribute("searchVO", (Object)searchVO);
        model.addAttribute("codeList", (Object)codeList);
        model.addAttribute("paginationInfo", (Object)paginationInfo);
        return "app/admin/brand/brandMgmtList.admin";
        return "";
    }
}
