package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.imageFile.service.ImageService;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("AdminBrandApiService")
@RequiredArgsConstructor
public class AdminBrandApiServiceImpl implements AdminBrandApiService {
    private final AdminBrandApiMapper adminBrandApiMapper;
    private final ImageService imageService;

    public Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandListCnt(searchMap);
    }

    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandList(searchMap);
    }

    public Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo) throws Exception {
        return adminBrandApiMapper.getBrandInfo(brandInfoVo);
    }

    /**
     * <pre>
     * 1. MethodName : addBrand
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    public String addBrand(NewBrandDTO newBrandDTO, MultipartFile[] files, HttpServletRequest request) throws Exception {

        if (adminBrandApiMapper.addBrand(newBrandDTO) > 0) {
            // 이미지 파일 등록
            if (StringUtil.getInt(imageService.addImageFile(newBrandDTO)) > 0) {
                imageService.uploadImageFile(files, request);
                return "Y";
            } else {
                return "N";
            }
        } else {
            return "N";
        }
    }

    /**
     * <pre>
     * 1. MethodName : addBrand
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param
     * @return
     * @throws Exception
     */
    public String modifyBrand(BrandInfoVo brandInfoVo) throws Exception {
        return adminBrandApiMapper.modifyBrand(brandInfoVo);
    }
}
