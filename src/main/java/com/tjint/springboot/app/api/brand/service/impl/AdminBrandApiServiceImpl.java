package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.common.BrandInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("AdminBrandApiService")
@RequiredArgsConstructor
public class AdminBrandApiServiceImpl implements AdminBrandApiService {
    private final AdminBrandApiMapper adminBrandApiMapper;

    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandList(searchMap);
    }

    public String addBrandInfo(BrandInfoVo brandInfoVo, HttpServletRequest request) throws Exception {
        return adminBrandApiMapper.addBrandInfo(brandInfoVo, request);
    }
}
