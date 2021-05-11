package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminBrandApiService")
@RequiredArgsConstructor
public class AdminBrandApiServiceImpl implements AdminBrandApiService {
    private final AdminBrandApiMapper adminBrandApiMapper;

    public List<BrandInfoVo> getBrandList() throws Exception {
        return adminBrandApiMapper.getBrandList();
    }
}
