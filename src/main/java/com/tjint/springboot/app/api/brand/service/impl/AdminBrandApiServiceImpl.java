package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.common.BrandInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("AdminBrandApiService")
@RequiredArgsConstructor
public class AdminBrandApiServiceImpl implements AdminBrandApiService {
    private final AdminBrandApiMapper adminBrandApiMapper;

    public Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandListCnt(searchMap);
    }

    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandList(searchMap);
    }

    public Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo) throws Exception {
        return adminBrandApiMapper.getBrandInfo(brandInfoVo);
    }

    public Integer addBrand(NewBrandDTO newBrandDTO) throws Exception {
        return adminBrandApiMapper.addBrand(newBrandDTO);
    }

    public String modifyBrand(BrandInfoVo brandInfoVo) throws Exception {
        return adminBrandApiMapper.modifyBrand(brandInfoVo);
    }
}
