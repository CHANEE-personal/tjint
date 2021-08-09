package com.tjint.springboot.common.imageFile.service.impl;

import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.transaction.Transactional;

@Mapper
public interface ImageMapper {

    /**
     * <pre>
     * 1. MethodName : addImageFile
     * 2. ClassName  : ImageMapper.java
     * 3. Comment    : 이미지 파일 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param newImageDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer addImageFile(NewImageDTO newImageDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : updateImageFile
     * 2. ClassName  : ImageMapper.java
     * 3. Comment    : 이미지 파일 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param newImageDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer updateImageFile(NewImageDTO newImageDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : deleteImageFile
     * 2. ClassName  : ImageMapper.java
     * 3. Comment    : 이미지 파일 삭제
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param newImageDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer deleteImageFile(NewImageDTO newImageDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : addAttachFile
     * 2. ClassName  : ImageMapper.java
     * 3. Comment    : 이미지 MASK 파일 정보 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param attachFileDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer addAttachFile(AttachFileDTO attachFileDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : deleteAttachFile
     * 2. ClassName  : ImageMapper.java
     * 3. Comment    : 이미지 MASK 파일 정보 삭제
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param attachFileDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer deleteAttachFile(AttachFileDTO attachFileDTO) throws Exception;
}
