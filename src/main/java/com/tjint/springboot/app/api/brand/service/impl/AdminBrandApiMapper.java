package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.common.BrandInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminBrandApiMapper {
    List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    String addBrandInfo(BrandInfoVo brandInfoVo, HttpServletRequest request) throws Exception;
}
