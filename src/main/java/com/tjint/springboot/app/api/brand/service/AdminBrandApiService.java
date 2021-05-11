package com.tjint.springboot.app.api.brand.service;

import com.tjint.springboot.common.BrandInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminBrandApiService {
    public List<BrandInfoVo> getBrandList() throws Exception;
}
