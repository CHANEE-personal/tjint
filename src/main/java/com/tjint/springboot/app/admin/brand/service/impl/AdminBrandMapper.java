package com.tjint.springboot.app.admin.brand.service.impl;

import com.tjint.springboot.app.admin.brand.service.SnsInfoVo;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminBrandMapper {
    List<BrandInfoVo> getBrandList(BrandInfoVo paramBrandInfoVo);

    int getBrandListCnt(BrandInfoVo paramBrandInfoVo);

    void modifyBrand(BrandInfoVo paramBrandInfoVo);

    void addBrand(BrandInfoVo paramBrandInfoVo);

    String selectLatestFileId();

    void addImageFileInfo(ImageFileVo paramImageFileVo);

    void addUrlLink(UrlLinkVo paramUrlLinkVo);

    List<SnsInfoVo> getCodeList(CodeVo paramCodeVo);

    void modifyCode(CodeVo paramCodeVo);

    void addCode(CodeVo paramCodeVo);

    String getLatestSnsId(CodeVo paramCodeVo);

    List<UrlLinkVo> getSnsLinkList(UrlLinkVo paramUrlLinkVo);

    void modifyImageFileInfo(ImageFileVo paramImageFileVo);

    void modifyUrlLink(UrlLinkVo paramUrlLinkVo);

    int getCodeListCnt(CodeVo paramCodeVo);
}
