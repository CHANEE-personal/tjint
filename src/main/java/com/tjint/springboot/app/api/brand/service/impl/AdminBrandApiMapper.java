package com.tjint.springboot.app.api.brand.service.impl;

import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.app.api.brand.service.NewCodeDTO;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminBrandApiMapper {

    /**
     * <pre>
     * 1. MethodName : getBrandListCnt
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    Integer getBrandListCnt(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getBrandList
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getCategoryListCnt
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 분야 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    Integer getCategoryListCnt(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getCategoryList
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 분야 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 07.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    List<NewCodeDTO> getCategoryList(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getCategoryInfo
     * 2. ClassName  : AdminBrandApiMapper.java
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
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 분야 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 08.
     * </pre>
     *
     * @param newCodeDTO
     * @return
     * @throws Exception
     */
    @org.springframework.transaction.annotation.Transactional
    public Integer insertCategory(NewCodeDTO newCodeDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : updateCategory
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 분야 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 08.
     * </pre>
     *
     * @param newCodeDTO
     * @return
     * @throws Exception
     */
    public Integer updateCategory(NewCodeDTO newCodeDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : addBrand
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer addBrand(NewBrandDTO newBrandDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : modifyBrand
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    Integer updateBrand(NewBrandDTO newBrandDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : deleteBrand
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 삭제
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    Integer deleteBrand(NewBrandDTO newBrandDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getBrandInfo
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 상세
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 04. 23.
     * </pre>
     *
     * @param newBrandDTO
     * @return
     * @throws Exception
     */
    Map<String, Object> getBrandInfo(NewBrandDTO newBrandDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getSnsLinkList
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : 브랜드 상세 SNS LIST
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 15.
     * </pre>
     *
     * @param newUrlLinkDTO
     * @return
     * @throws Exception
     */
    List<NewUrlLinkDTO> getSnsLinkList(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : addSns
     * 2. ClassName  : AdminBrandApiMapper.java
     * 3. Comment    : SNS 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 07. 18.
     * </pre>
     *
     * @param newCodeDTO
     * @return
     * @throws Exception
     */
    Integer addSns(NewCodeDTO newCodeDTO) throws Exception;
}
