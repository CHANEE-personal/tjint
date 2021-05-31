package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.common.BrandInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminBrandApiMapper {

    Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception;

    List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    @Transactional
    Integer addBrand(NewBrandDTO newBrandDTO) throws Exception;

    String modifyBrand(BrandInfoVo brandInfoVo) throws Exception;

    Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo) throws Exception;
}
