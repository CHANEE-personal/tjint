package com.tjint.springboot.common.imageFile.service.impl;

import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.imageFile.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service("ImageService")
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

    /**
     * 오늘 날짜
     **/
    private final LocalDate nowDate = LocalDate.now();
    private final String today = nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

    /**
     * 업로드 경로
     **/
    private final String uploadPath = Paths.get("C:", "develop", "upload", today).toString();

    /**
     * 서버에 생성할 파일명을 처리할 랜덤 문자열 변환
     **/
    private final String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * <pre>
     * 1. MethodName : addImageFile
     * 2. ClassName  : ImageServiceImpl.java
     * 3. Comment    : 이미지 파일 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 02.
     * </pre>
     *
     * @param newImageDTO
     * @return
     * @throws Exception
     */
    public Integer addImageFile(NewImageDTO newImageDTO) throws Exception {

        newImageDTO.setBoardTypeCd("brdt001");
        newImageDTO.setImageTypeCd("imgt001");
        newImageDTO.setSortOrder(1);
        newImageDTO.setImageFileInfoSeq(1);

        // mainImage app_image_file_info 등록
        imageMapper.addImageFile(newImageDTO);

        for (int i = 1; i < 6; i++) {
            newImageDTO.setImageTypeCd("imgt002");
            newImageDTO.setSortOrder(i);
            newImageDTO.setImageFileInfoSeq(1);

            // subImage app_image_file_info 등록
            imageMapper.addImageFile(newImageDTO);
        }

        return 1;
    }

    /**
     * <pre>
     * 1. MethodName : uploadImageFile
     * 2. ClassName  : ImageServiceImpl.java
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
    public String uploadImageFile(MultipartFile[] files, HttpServletRequest request) throws Exception {

        File dir = new File(uploadPath);
        if (dir.exists() == false) {
            dir.mkdirs();
        }

        for (MultipartFile file : files) {
            try {
                final String fileId = today.substring(2);
                final String extension = "";
                final String saveName = getRandomString() + "." + extension;
                File target = new File(uploadPath, saveName);
                file.transferTo(target);

                AttachFileDTO attachFileDTO = new AttachFileDTO();
                attachFileDTO.setFileId(fileId);                                         // 파일ID
                attachFileDTO.setFileSeq(0);                                             // 파일구분
                attachFileDTO.setFilename(file.getOriginalFilename());                   // 파일명
                attachFileDTO.setFileSize(file.getSize());  // 파일Size
                attachFileDTO.setFileMask(today);                                        // 파일Mask

                // 이미지 정보 insert
                imageMapper.addAttachFile(attachFileDTO);

            } catch (Exception e) {
                throw new Exception();
            }
        }

        return "Y";
    }
}