package com.tjint.springboot.app.admin.login.service.impl;

import com.tjint.springboot.common.BrandInfoVo;
import org.apache.ibatis.annotations.Mapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminLoginMapper {
    Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception;

    List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    @Transactional
    Integer addBrandInfo(Map<String, Object> brandMap) throws Exception;

    String modifyBrand(BrandInfoVo brandInfoVo) throws Exception;
}
