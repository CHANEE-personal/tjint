package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.common.BrandInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminBrandApiMapper {
    List<BrandInfoVo> getBrandList() throws Exception;
}
