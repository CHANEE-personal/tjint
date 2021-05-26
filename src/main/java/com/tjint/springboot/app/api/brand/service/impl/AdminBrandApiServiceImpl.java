package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("AdminBrandApiService")
@RequiredArgsConstructor
public class AdminBrandApiServiceImpl implements AdminBrandApiService {
    private final AdminBrandApiMapper adminBrandApiMapper;

    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandList(searchMap);
    }

    public Integer addBrandInfo(Map<String, Object> brandMap) throws Exception {
        return adminBrandApiMapper.addBrandInfo(brandMap);
    }

    public String modifyBrand(BrandInfoVo brandInfoVo) throws Exception {
        return adminBrandApiMapper.modifyBrand(brandInfoVo);
    }
}
