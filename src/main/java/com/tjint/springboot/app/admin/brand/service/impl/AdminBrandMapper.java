package com.tjint.springboot.app.admin.brand.service.impl;

import com.tjint.springboot.app.admin.brand.service.SnsInfoVo;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @package : com.tjint.springboot.app.admin.brand.service.impl
 * @method : AdminBrandMapper
 * @date : 12/05/2021 5:33 오후
 * @author : chanee
 * @version : 1.0.0
 * @modifyed : 브랜드관리
 **/
@Mapper
public interface AdminBrandMapper {
    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : getBrandListCnt
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드갯수
     **/
    int getBrandListCnt(Map<String, Object> searchMap);

    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : getBrandList
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드리스트
     **/
    List<BrandInfoVo> getBrandList(Map<String, Object> searchMap);

    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : modifyBrand
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드수정
     **/
    int modifyBrand(BrandInfoVo paramBrandInfoVo);

    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : addBrand
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드등록
     **/
    int addBrand(BrandInfoVo paramBrandInfoVo);

    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : getBrandInfo
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드상세
     **/
    Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo);

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
