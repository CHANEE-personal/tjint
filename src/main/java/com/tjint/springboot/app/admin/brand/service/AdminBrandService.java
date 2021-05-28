package com.tjint.springboot.app.admin.brand.service;

import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public interface AdminBrandService {

    /** 브랜드 갯수 **/
    int getBrandListCnt(Map<String, Object> searchMap);

    /** 브랜드 리스트 **/
    List<BrandInfoVo> getBrandList(Map<String, Object> searchMap);

    /** 브랜드 등록 **/
    int addBrand(BrandInfoVo brandInfoVo) throws Exception;

    /** 브랜드 수정 **/
    int modifyBrand(BrandInfoVo paramBrandInfoVo);

    /** 브랜드 상세 **/
    Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo) throws Exception;

    String modifyBrandInfo(BrandInfoVo paramBrandInfoVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    String addBrandInfo(BrandInfoVo paramBrandInfoVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    void addUrlLink(UrlLinkVo paramUrlLinkVo);

    void modifyUrlLink(UrlLinkVo paramUrlLinkVo);

    List<SnsInfoVo> getCodeList(CodeVo paramCodeVo) throws Exception;

    void modifyCode(CodeVo paramCodeVo);

    void addSnsInfo(CodeVo paramCodeVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    String modifySnsInfo(CodeVo paramCodeVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    List<UrlLinkVo> getSnsLinkList(UrlLinkVo paramUrlLinkVo) throws Exception;


    void modifyImageFileInfo(ImageFileVo paramImageFileVo);

    int getCodeListCnt(CodeVo paramCodeVo);
}
