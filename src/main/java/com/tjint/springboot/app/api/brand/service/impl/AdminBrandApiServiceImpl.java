package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.imageFile.service.ImageService;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.urlLink.service.UrlLinkService;
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
    private final UrlLinkService urlLinkService;

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
    public String addBrand(NewBrandDTO newBrandDTO,
                           NewImageDTO newImageDTO,
                           NewUrlLinkDTO newUrlLinkDTO,
                           MultipartFile[] files, HttpServletRequest request) throws Exception {

        String resultMsg = "";
        if (adminBrandApiMapper.addBrand(newBrandDTO) > 0) {
            // 이미지 파일 등록
            if (StringUtil.getInt(imageService.addImageFile(newImageDTO)) > 0) {
                // 이미지 파일 업로드
                if (StringUtil.getInt(imageService.uploadImageFile(files, request), 0) > 0) {
                    // URL 링크 등록
                    if(StringUtil.getInt(urlLinkService.addUrlLink(newUrlLinkDTO),0) > 0) {
                        resultMsg = "S00";      // 등록 성공
                    } else {
                        resultMsg = "F00";     // 등록 실패
                    }
                } else {
                    resultMsg = "F01";     // 이미지 업로드 실패
                }
            } else {
                resultMsg = "F01";      // 이미지 파일 정보 insert 실패
            }
        } else {
            return "F02";            // 브랜드 등록 실패
        }

        return resultMsg;
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
