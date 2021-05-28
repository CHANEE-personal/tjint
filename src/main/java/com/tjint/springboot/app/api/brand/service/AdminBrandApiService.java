package com.tjint.springboot.app.api.brand.service;

import com.tjint.springboot.common.BrandInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdminBrandApiService {
    public Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception;

    /** 브랜드 리스트 검색 **/
    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    /** 브랜드 상세 **/
    public Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo) throws Exception;

    /** 브랜드 등록 **/
    public Integer addBrand(BrandInfoVo brandInfoVo) throws Exception;

    /** 브랜드 삭제 **/
    public String modifyBrand(BrandInfoVo brandInfoVo) throws Exception;
}
