package com.tjint.springboot.app.admin.brand.service;

import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface AdminBrandService {
    List<BrandInfoVo> getBrandList(BrandInfoVo paramBrandInfoVo);

    int getBrandListCnt(BrandInfoVo paramBrandInfoVo);

    String modifyBrandInfo(BrandInfoVo paramBrandInfoVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    String addBrandInfo(BrandInfoVo paramBrandInfoVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    void addUrlLink(UrlLinkVo paramUrlLinkVo);

    void modifyUrlLink(UrlLinkVo paramUrlLinkVo);

    List<SnsInfoVo> getCodeList(CodeVo paramCodeVo) throws Exception;

    void modifyCode(CodeVo paramCodeVo);

    void addSnsInfo(CodeVo paramCodeVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    String modifySnsInfo(CodeVo paramCodeVo, HttpServletRequest paramHttpServletRequest) throws Exception;

    List<UrlLinkVo> getSnsLinkList(UrlLinkVo paramUrlLinkVo) throws Exception;

    void modifyBrand(BrandInfoVo paramBrandInfoVo);

    void modifyImageFileInfo(ImageFileVo paramImageFileVo);

    int getCodeListCnt(CodeVo paramCodeVo);
}
