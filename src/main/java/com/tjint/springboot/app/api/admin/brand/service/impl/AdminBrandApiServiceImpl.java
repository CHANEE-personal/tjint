package com.tjint.springboot.app.api.admin.brand.service.impl;

import com.tjint.springboot.app.api.admin.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.admin.brand.service.NewBrandDTO;
import com.tjint.springboot.app.api.admin.brand.service.NewCodeDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.imageFile.service.ImageService;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.urlLink.service.UrlLinkService;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service("AdminBrandApiService")
@RequiredArgsConstructor
public class AdminBrandApiServiceImpl implements AdminBrandApiService {

    private final AdminBrandApiMapper adminBrandApiMapper;
    private final AdminCategoryApiMapper adminCategoryApiMapper;
    private final ImageService imageService;
    private final UrlLinkService urlLinkService;
    private final SearchCommon searchCommon;

    /**
     * <pre>
     * 1. MethodName : getBrandListCnt
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandListCnt(searchMap);
    }

    /**
     * <pre>
     * 1. MethodName : getBrandList
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public List<NewBrandDTO> getBrandList(Map<String, Object> searchMap) throws Exception {
        return adminBrandApiMapper.getBrandList(searchMap);
    }

    /**
     * <pre>
     * 1. MethodName : getBrandInfo
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 상세
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param  brandSeq
     * @return ConcurrentHashMap
     * @throws Exception
     */
    public ConcurrentHashMap<String, Object> getBrandInfo(Integer brandSeq) throws Exception {
        ConcurrentHashMap brandInfoMap = new ConcurrentHashMap();
        NewBrandDTO newBrandDTO = new NewBrandDTO();
        newBrandDTO.setBrandSeq(brandSeq);

        NewImageDTO newImageDTO = new NewImageDTO();
        newImageDTO.setBoardSeq(brandSeq);

        NewUrlLinkDTO newUrlLinkDTO = new NewUrlLinkDTO();
        newUrlLinkDTO.setBoardSeq(brandSeq);
        newUrlLinkDTO.setBoardTypeCd("brdt001");

        brandInfoMap.put("brandInfo", this.adminBrandApiMapper.getBrandInfo(newBrandDTO));
        brandInfoMap.put("imageList", this.adminBrandApiMapper.getImageList(newImageDTO));
        brandInfoMap.put("snsLinkList", this.adminBrandApiMapper.getSnsLinkList(newUrlLinkDTO));

        return brandInfoMap;
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

        NewCodeDTO newCodeDTO = new NewCodeDTO();

        // creator, updater 인증 부여
        searchCommon.giveAuth(request, newBrandDTO);

        newImageDTO.setSortOrder(1);
        newImageDTO.setBoardTypeCd("brdt002");

        Integer codeId = StringUtil.getInt(newBrandDTO.getMenuCategoryCd(),0)+1;
        String codeNm = "mu00"+codeId;
        newCodeDTO.setCodeId(codeNm);

        newBrandDTO.setMenuCategoryNm(StringUtil.getString(this.adminCategoryApiMapper.getCategoryInfo(newCodeDTO).get("code_name"),""));

        String flag = "A";
        if (adminBrandApiMapper.addBrand(newBrandDTO) > 0) {
            newImageDTO.setBoardSeq(newBrandDTO.getBrandSeq());
            // 이미지 파일 등록
            if (StringUtil.getInt(imageService.addImageFile(request,newImageDTO, files, flag),0) > 0) {
                // URL 링크 등록
                newUrlLinkDTO.setBoardSeq(newBrandDTO.getBrandSeq());
                if(StringUtil.getInt(urlLinkService.addUrlLink(request,newUrlLinkDTO, flag),0) > 0) {
                    resultMsg = "Y";      // 등록 성공
                } else {
                    resultMsg = "N";     // 등록 실패
                }
            } else {
                resultMsg = "N";      // 이미지 파일 정보 insert 실패
            }
        } else {
            resultMsg = "N";            // 브랜드 등록 실패
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
     * @param  newBrandDTO
     * @return
     * @throws Exception
     */
    public String updateBrand(NewBrandDTO newBrandDTO,
							  NewImageDTO newImageDTO,
							  NewUrlLinkDTO newUrlLinkDTO,
							  MultipartFile[] files, HttpServletRequest request) throws Exception {

        String resultMsg = "";

        NewCodeDTO newCodeDTO = new NewCodeDTO();

        // creator, updater 인증 부여
        searchCommon.giveAuth(request, newBrandDTO);

        newImageDTO.setSortOrder(1);
        newImageDTO.setBoardTypeCd("brdt002");

        Integer codeId = StringUtil.getInt(newBrandDTO.getMenuCategoryCd(),0)+1;
        String codeNm = "mu00"+codeId;
        newCodeDTO.setCodeId(codeNm);

        newBrandDTO.setMenuCategoryNm(StringUtil.getString(this.adminCategoryApiMapper.getCategoryInfo(newCodeDTO).get("code_name"),""));

        String flag = "U";
        if (adminBrandApiMapper.updateBrand(newBrandDTO) > 0) {
            newImageDTO.setBoardSeq(newBrandDTO.getBrandSeq());
            // 이미지 파일 등록
            if (StringUtil.getInt(imageService.addImageFile(request, newImageDTO, files, flag),0) > 0) {
                // URL 링크 등록
                newUrlLinkDTO.setBoardSeq(newBrandDTO.getBrandSeq());
                if(StringUtil.getInt(urlLinkService.addUrlLink(request, newUrlLinkDTO, flag),0) > 0) {
                    resultMsg = "Y";      // 등록 성공
                } else {
                    resultMsg = "N";     // 등록 실패
                }
            } else {
                resultMsg = "N";      // 이미지 파일 정보 insert 실패
            }
        } else {
            resultMsg = "N";            // 브랜드 등록 실패
        }

        return resultMsg;
    }

    /**
     * <pre>
     * 1. MethodName : deleteBrand
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 삭제
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param  newBrandDTO
     * @return
     * @throws Exception
     */
    public Integer deleteBrand(NewBrandDTO newBrandDTO) throws Exception {
        return this.adminBrandApiMapper.deleteBrand(newBrandDTO);
    }

    /**
     * <pre>
     * 1. MethodName : getBrandRegist
     * 2. ClassName  : AdminBrandApiServiceImpl.java
     * 3. Comment    : 브랜드 등록 페이지 정보
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @return resultMap
     * @throws Exception
     */
    public ConcurrentHashMap<String, Object> getBrandRegist() throws Exception {
        ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

        ConcurrentHashMap<String, Object> searchMap = new ConcurrentHashMap<>();

        //브랜드 소개 분야 조회
        searchMap.put("parentCd", "ct000");
        searchMap.put("visible","Y");

        Integer categoryListCnt = this.adminCategoryApiMapper.getCategoryListCnt(searchMap);
        List<NewCodeDTO> categoryList = null;
        if(categoryListCnt > 0) {
            categoryList = this.adminCategoryApiMapper.getCategoryList(searchMap);
        }

        //브랜드 소개 메뉴구분 조회
        searchMap.put("parentCd", "mu000");
        searchMap.put("visible", "Y");

        Integer menuListCnt = this.adminCategoryApiMapper.getCategoryListCnt(searchMap);
        List<NewCodeDTO> menuList = null;
        if(menuListCnt > 0) {
            menuList = this.adminCategoryApiMapper.getCategoryList(searchMap);
        }

        //브랜드 소개 SNS List 조회
        searchMap.put("parentCd", "lnkt002");
        searchMap.put("visible", "Y");
        Integer snsLinkListCnt = this.adminCategoryApiMapper.getCategoryListCnt(searchMap);
        List<NewCodeDTO> snsLinkList = null;
        if(snsLinkListCnt > 0) {
            snsLinkList = this.adminCategoryApiMapper.getCategoryList(searchMap);
        }

        resultMap.put("categoryList", categoryList);
        resultMap.put("menuList", menuList);
        resultMap.put("snsLinkList", snsLinkList);

        return resultMap;
    }
}
