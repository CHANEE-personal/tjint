package com.tjint.springboot.app.api.brand.service;

import com.tjint.springboot.common.BrandInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdminBrandApiService {
    /** 브랜드 리스트 검색 **/
    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    /** 브랜드 등록 **/
    public Integer addBrandInfo(Map<String, Object> brandMap) throws Exception;

    /** 브랜드 삭제 **/
    public String modifyBrand(BrandInfoVo brandInfoVo) throws Exception;
}
