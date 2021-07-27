package com.tjint.springboot.app.api.brand.service;

import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public interface AdminBrandApiService {
    /**
     * <pre>
     * 1. MethodName : getBrandListCnt
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 브랜드 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getBrandList
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 브랜드 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getCategoryListCnt
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 분야 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public Integer getCategoryListCnt(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getCategoryList
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 분야 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public List<NewCodeDTO> getCategoryList(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getSns
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 분야 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */

    /**
     * <pre>
     * 1. MethodName : getBrandInfo
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 브랜드 상세
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    public Map<String, Object> getBrandInfo(NewBrandDTO newBrandDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getBrandInfo
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 브랜드 상세 SNS LIST
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 15.
     * </pre>
     *
     * @param newUrlLinkDTO
     * @return
     * @throws Exception
     */
    public List<NewUrlLinkDTO> getSnsLinkList(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getCategoryInfo
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 분야 상세
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 08.
     * </pre>
     *
     * @param newCodeDTO
     * @return
     * @throws Exception
     */
    public Map<String, Object> getCategoryInfo(NewCodeDTO newCodeDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : insertCategory
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 분야 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 08.
     * </pre>
     *
     * @param newCodeDTO
     * @return
     * @throws Exception
     */
    public String insertCategory(NewCodeDTO newCodeDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : updateCategory
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 분야 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 08.
     * </pre>
     *
     * @param newCodeDTO
     * @return
     * @throws Exception
     */
    public String updateCategory(NewCodeDTO newCodeDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : addBrand
     * 2. ClassName  : AdminBrandApiService.java
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
                           MultipartFile[] files, HttpServletRequest request) throws Exception;

    /**
     * <pre>
     * 1. MethodName : updateBrand
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 브랜드 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 18.
     * </pre>
     *
     * @param newBrandDTO
     * @param newImageDTO
     * @param newUrlLinkDTO
     * @param files
     * @return
     * @throws Exception
     */
    public String updateBrand(NewBrandDTO newBrandDTO,
                               NewImageDTO newImageDTO,
                               NewUrlLinkDTO newUrlLinkDTO,
                               MultipartFile[] files, HttpServletRequest request) throws Exception;

    /**
     * <pre>
     * 1. MethodName : deleteBrand
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : 브랜드 삭제
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 18.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    public Integer deleteBrand(NewBrandDTO newBrandDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : addSns
     * 2. ClassName  : AdminBrandApiService.java
     * 3. Comment    : SNS 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 18.
     * </pre>
     *
     * @param newCodeDTO
     * @param files
     * @return
     * @throws Exception
     */
    public Integer addSns(NewCodeDTO newCodeDTO, MultipartFile files) throws Exception;

}
