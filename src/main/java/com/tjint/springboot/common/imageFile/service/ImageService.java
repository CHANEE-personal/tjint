package com.tjint.springboot.common.imageFile.service;

import com.tjint.springboot.app.api.admin.brand.service.NewCodeDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Service
public interface ImageService {

    /**
     * <pre>
     * 1. MethodName : addImageFile
     * 2. ClassName  : ImageService.java
     * 3. Comment    : 이미지 파일 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param newImageDTO
     * @return
     * @throws Exception
     */
    Integer addImageFile(HttpServletRequest request,
                         NewImageDTO newImageDTO, MultipartFile[] files, String flag) throws Exception;

    /**
     * <pre>
     * 1. MethodName : uploadImageFile
     * 2. ClassName  : ImageService.java
     * 3. Comment    : 이미지 파일 업로드
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param files
     * @param request
     * @return
     * @throws Exception
     */
    String uploadImageFile(NewCodeDTO newCodeDTO, MultipartFile[] files, HttpServletRequest request) throws Exception;
}
