package com.tjint.springboot.common.imageFile.service;

import com.tjint.springboot.common.imageFile.NewImageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public Integer addImageFile(NewImageDTO newImageDTO) throws Exception;

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
    public String uploadImageFile(List<MultipartFile> files, HttpServletRequest request) throws Exception;
}
