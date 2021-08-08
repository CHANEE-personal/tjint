package com.tjint.springboot.common.imageFile.service.impl;

import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.imageFile.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Service("ImageService")
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

    /**
     * 업로드 경로
     **/
    private final String uploadPath = "/Users/tj02/Documents/image/";


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
    public Integer addImageFile(NewImageDTO newImageDTO, MultipartFile[] files, String flag) throws Exception {

        // 확장자
        String ext = "";
        // 파일명
        String fileId = "";
        // 파일 Mask
        String fileMask = "";
        // 파일 크기
        long fileSize = 0;
        int mainCnt = 1;

        AttachFileDTO attachFileDTO = new AttachFileDTO();
        attachFileDTO.setJBoardSeq(newImageDTO.getBoardSeq());
        imageMapper.deleteAttachFile(attachFileDTO);

        for (MultipartFile file : files) {
            fileId = currentDate();
            if(file.getSize() > 0) {
                if(mainCnt == 1) {
                    newImageDTO.setImageTypeCd("imgt001");
                } else {
                    newImageDTO.setImageTypeCd("imgt002");
                }

                newImageDTO.setBoardTypeCd("brdt001");
                newImageDTO.setSortOrder(1);
                newImageDTO.setCreator(1);
                newImageDTO.setVisible("Y");
                newImageDTO.setUpdater(1);
                newImageDTO.setImageFileSeq(1);

                // mainImage app_image_file_info 등록
                if("U".equals(flag)) {
                    newImageDTO.setImageFileId(fileId);
                    if (imageMapper.updateImageFile(newImageDTO) > 0) {
                        mainCnt++;
                    }
                } else {
                    newImageDTO.setImageFileId(fileId);
                    if (imageMapper.addImageFile(newImageDTO) > 0) {
                        mainCnt++;
                    }
                }

                ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();

                fileMask = fileId + '.' + ext;
                fileSize = file.getSize();

                String filePath = uploadPath + fileMask;
                file.transferTo(new File(filePath));

                attachFileDTO.setFileId(fileId);                                         // 파일ID
                attachFileDTO.setFileSeq(0);                                             // 파일구분
                attachFileDTO.setFilename(file.getOriginalFilename());                   // 파일명
                attachFileDTO.setFileSize(fileSize);  // 파일Size
                attachFileDTO.setFileMask(fileMask);                                     // 파일Mask
                attachFileDTO.setFilePath(uploadPath + fileMask);
                attachFileDTO.setDownloadCnt(0);
                attachFileDTO.setFilename(file.getOriginalFilename());

                // 이미지 정보 insert
                if("U".equals(flag)) {
                    if(imageMapper.addAttachFile(attachFileDTO)>0) {
                        mainCnt++;
                    }
                } else {
                    if(imageMapper.addAttachFile(attachFileDTO)>0) {
                        mainCnt++;
                    }
                }
            }
        }

        for (int i = files.length; i < 6; i++) {
            newImageDTO.setImageTypeCd("imgt002");
            newImageDTO.setImageFileId("");
            newImageDTO.setSortOrder(i);
            newImageDTO.setCreator(1);
            newImageDTO.setUpdater(1);
            newImageDTO.setVisible("N");
            newImageDTO.setImageFileSeq(1);

            // subImage app_image_file_info 등록
            if("U".equals(flag)) {
                imageMapper.updateImageFile(newImageDTO);
            } else {
                imageMapper.addImageFile(newImageDTO);
            }
        }

        return mainCnt;
    }
    public String currentDate() throws Exception {
        // 현재 날짜 구하기
        String rtnStr = null;
        String pattern = "MMddHHmmssSSS";
        SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        rtnStr = sdfCurrent.format(Long.valueOf(ts.getTime()));
        return rtnStr;
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

        // 현재 날짜 구하기
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        Calendar cl = Calendar.getInstance();
        String strToday = sdf.format(cl.getTime());

        // 파일 확장자
        String ext = "";
        // 파일명
        String fileId = "";
        // 파일 Mask
        String fileMask = "";
        // 파일 크기
        long fileSize = 0;

        File dir = new File(uploadPath);
        if (dir.exists() == false) {
            dir.mkdirs();
        }

        for (MultipartFile file : files) {
            try {
                ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
                fileId = strToday;
                fileMask = strToday + '.' + ext;
                fileSize = file.getSize();

                String filePath = uploadPath + fileMask;
                file.transferTo(new File(filePath));

                AttachFileDTO attachFileDTO = new AttachFileDTO();
                attachFileDTO.setFileId(fileId);                                         // 파일ID
                attachFileDTO.setFileSeq(0);                                             // 파일구분
                attachFileDTO.setFilename(file.getOriginalFilename());                   // 파일명
                attachFileDTO.setFileSize(fileSize);  // 파일Size
                attachFileDTO.setFileMask(fileMask);                                        // 파일Mask
                attachFileDTO.setFilePath(uploadPath + fileMask);
                attachFileDTO.setDownloadCnt(0);
                attachFileDTO.setFilename(file.getOriginalFilename());

                // 이미지 정보 insert
                imageMapper.addAttachFile(attachFileDTO);

            } catch (Exception e) {
                throw new Exception();
            }
        }

        return "Y";
    }
}
