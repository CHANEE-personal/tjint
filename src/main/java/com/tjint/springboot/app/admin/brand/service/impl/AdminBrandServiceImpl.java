package com.tjint.springboot.app.admin.brand.service.impl;

import com.tjint.springboot.app.admin.brand.service.AdminBrandService;
import com.tjint.springboot.app.admin.brand.service.SnsInfoVo;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.UserInfoVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("AdminBrandService")
@RequiredArgsConstructor
public class AdminBrandServiceImpl implements AdminBrandService {

    private final AdminBrandMapper adminBrandMapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : getBrandListCnt
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드갯수
     **/
    public int getBrandListCnt(Map<String, Object> searchMap) {
        return this.adminBrandMapper.getBrandListCnt(searchMap);
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.service.impl
     * @method : getBrandList
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드리스트
     **/
    public List<BrandInfoVo> getBrandList(Map<String, Object> searchMap) {
        return this.adminBrandMapper.getBrandList(searchMap);
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.serviceImpl
     * @method : addBrand
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드등록
     **/
    public int addBrand(BrandInfoVo brandInfoVo) throws Exception {
        return this.adminBrandMapper.addBrand(brandInfoVo);
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.serviceImpl
     * @method : brandInfo
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드상세
     **/
    public Map<String, Object> getBrandInfo(BrandInfoVo brandInfoVo) throws Exception {
        return this.adminBrandMapper.getBrandInfo(brandInfoVo);
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.serviceImpl
     * @method : modifyBrand
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드수정
     **/
    public int modifyBrand(BrandInfoVo requestVo) {
        return this.adminBrandMapper.modifyBrand(requestVo);
    }

    public String modifyBrandInfo(BrandInfoVo paramBrandInfoVo, HttpServletRequest paramHttpServletRequest) throws Exception {
        return null;
    }

    public String addBrandInfo(BrandInfoVo requestVO, HttpServletRequest request) throws Exception {
        UserInfoVo loginVO = (UserInfoVo)request.getSession().getAttribute("adminVO");
        requestVO.setCreator(Integer.valueOf(loginVO.getUserSeq()));
        requestVO.setUpdater(Integer.valueOf(loginVO.getUserSeq()));
        addBrand(requestVO);
        addBrandImageDummy(requestVO);
        uploadImageFile(requestVO, request);
        upsertUrlLink(requestVO, "A");
        return "Y";
    }

    private void addBrandImageDummy(BrandInfoVo requestVO) {
        ImageFileVo imageVO = new ImageFileVo();
        imageVO.setBoardTypeCd("brdt001");
        imageVO.setBoardSeq(requestVO.getBrandSeq());
        imageVO.setImageTypeCd("imgt001");
        imageVO.setSortOrder(Integer.valueOf(1));
        imageVO.setImageFileId("");
        imageVO.setImageFileSeq(Integer.valueOf(1));
        imageVO.setVisible("N");
        imageVO.setUpdater(requestVO.getUpdater());
        this.adminBrandMapper.addImageFileInfo(imageVO);
        for (int i = 1; i < 6; i++) {
            imageVO.setImageTypeCd("imgt002");
            imageVO.setSortOrder(Integer.valueOf(i));
            this.adminBrandMapper.addImageFileInfo(imageVO);
        }
    }

    private String uploadImageFile(BrandInfoVo requestVO, HttpServletRequest request) throws Exception {
//        MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest)request;
//        String fileName = "", filePath = "", fileId = "", uploadFileName = "";
//        String uploadFilePath = PropertiesByStage.IMAGE_UPLOAD_PATH;
//        Iterator<String> fileIter = mptRequest.getFileNames();
//        while (fileIter.hasNext()) {
//            MultipartFile mFile = mptRequest.getFile(fileIter.next());
//            if (mFile.getSize() > 0L) {
//                long maxFileSize = Long.valueOf(EgovProperties.getProperty("Globals.imageUploadSize")).longValue();
//                if (mFile.getSize() > maxFileSize)
//                    throw new FileException("fileError");
//                HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile, uploadFilePath);
//                fileName = map.get("originalFileName");
//                filePath = (String)map.get("filePath") + File.separator + (String)map.get("uploadFileName");
//                fileId = ((String)map.get("uploadFileName")).substring(4).replaceAll("." + (String)map.get("fileExtension"), "");
//                uploadFileName = map.get("uploadFileName");
//                JFileVO fileVo = new JFileVO();
//                fileVo.setFilePath(PropertiesByStage.IMAGE_UPLOAD_PATH + File.separator + uploadFileName);
//                fileVo.setFileSize(Long.parseLong(map.get("fileSize")));
//                fileVo.setFileName(fileName);
//                fileVo.setFileMask(uploadFileName);
//                fileVo.setFileId(fileId);
//                String latestFileId = this.jFileService.addAttachFile((JFileDetails)fileVo);
//                ImageFileVo imageVO = new ImageFileVo();
//                imageVO.setBoardTypeCd("brdt001");
//                imageVO.setBoardSeq(requestVO.getBrandSeq());
//                if ("mainImage".equals(mFile.getName())) {
//                    imageVO.setImageTypeCd("imgt001");
//                    imageVO.setSortOrder(Integer.valueOf(1));
//                } else {
//                    imageVO.setImageTypeCd("imgt002");
//                    Integer sortOrder = Integer.valueOf(mFile.getName().substring(8));
//                    imageVO.setSortOrder(sortOrder);
//                }
//                imageVO.setImageFileId(latestFileId);
//                imageVO.setImageFileSeq(Integer.valueOf(1));
//                imageVO.setVisible("Y");
//                imageVO.setUpdater(requestVO.getUpdater());
//                modifyImageFileInfo(imageVO);
//                this.logger.debug("[ filePath : " + filePath + " ]");
//                this.logger.debug("[ fileSize : " + (String)map.get("fileSize") + " ]");
//                this.logger.debug("[ originalFileName : " + fileName + " ]");
//                this.logger.debug("[ uploadFileName : " + uploadFileName + " ]");
//                this.logger.debug("[ fileExtension : " + (String)map.get("fileExtension") + " ]");
//            }
//        }
        return "Y";
    }

    private void upsertUrlLink(BrandInfoVo requestVo, String flag) {
        UrlLinkVo brandLinkVo = new UrlLinkVo();
        brandLinkVo.setBoardTypeCd("brdt001");
        brandLinkVo.setBoardSeq(requestVo.getBrandSeq());
        brandLinkVo.setLinkTypeCd("lnkt001");
        brandLinkVo.setVisible(requestVo.getBrandLinkVisible());
        if ("Y".equals(requestVo.getBrandLinkVisible())) {
            brandLinkVo.setLinkAddress(requestVo.getBrandLink());
        } else {
            brandLinkVo.setVisible("N");
        }
        brandLinkVo.setSortOrder(Integer.valueOf(1));
        brandLinkVo.setUpdater(requestVo.getUpdater());
        if ("A".equals(flag)) {
            addUrlLink(brandLinkVo);
        } else {
            brandLinkVo.setLinkAddress(requestVo.getBrandLink());
            modifyUrlLink(brandLinkVo);
        }
        String[] snsArr = requestVo.getSnsLinks().split(";");
        for (int i = 0; i < snsArr.length; i++) {
            String[] sns = snsArr[i].split(",");
            UrlLinkVo snsLinkVo = new UrlLinkVo();
            snsLinkVo.setBoardTypeCd("brdt001");
            snsLinkVo.setBoardSeq(requestVo.getBrandSeq());
            snsLinkVo.setLinkTypeCd(sns[0]);
            if ("Y".equals(sns[1])) {
                snsLinkVo.setLinkAddress(sns[2]);
            } else {
                snsLinkVo.setLinkAddress("");
            }
            snsLinkVo.setSortOrder(Integer.valueOf(i + 1));
            snsLinkVo.setVisible(sns[1]);
            snsLinkVo.setUpdater(requestVo.getUpdater());
            if ("A".equals(flag)) {
                addUrlLink(snsLinkVo);
            } else if ("0".equals(sns[3])) {
                addUrlLink(snsLinkVo);
            } else {
                modifyUrlLink(snsLinkVo);
            }
        }
    }

    public void addUrlLink(UrlLinkVo urlLinkVo) {
        if (urlLinkVo.getLinkAddress() != null && !"".equals(urlLinkVo.getLinkAddress().trim()))
            this.adminBrandMapper.addUrlLink(urlLinkVo);
    }

    public void modifyUrlLink(UrlLinkVo urlLinkVo) {
        if (urlLinkVo.getLinkAddress() != null && !"".equals(urlLinkVo.getLinkAddress().trim()))
            this.adminBrandMapper.modifyUrlLink(urlLinkVo);
    }

    public List<SnsInfoVo> getCodeList(CodeVo codeVo) throws Exception {
        List<SnsInfoVo> codeList = this.adminBrandMapper.getCodeList(codeVo);
//        if ("lnkt002".equals(codeVo.getParentCd()))
//            for (SnsInfoVo link : codeList) {
//                if (link.getFilePath() != null && !"".equals(link.getFilePath())) {
//                    String filePath = ImageUtil.getImagePath(link.getFilePath());
//                    link.setFilePath(filePath);
//                }
//            }
        return codeList;
    }

    public void modifyCode(CodeVo requestVO) {
        this.adminBrandMapper.modifyCode(requestVO);
    }

    public void addSnsInfo(CodeVo codeVo, HttpServletRequest request) throws Exception {
        codeVo.setCodeValue("");
        codeVo.setCodeDesc(codeVo.getCodeName());
        codeVo.setParentCd("lnkt002");
        this.adminBrandMapper.addCode(codeVo);
        String snsId = this.adminBrandMapper.getLatestSnsId(codeVo);
        codeVo.setCodeId(snsId);
        uploadSnsImage(codeVo, request);
    }

    private String uploadSnsImage(CodeVo codeVo, HttpServletRequest request) throws Exception {
//        MultipartHttpServletRequest mptRequest = (MultipartHttpServletRequest)request;
//        String fileName = "", filePath = "", fileId = "", uploadFileName = "";
//        String uploadFilePath = PropertiesByStage.IMAGE_UPLOAD_PATH;
//        Iterator<String> fileIter = mptRequest.getFileNames();
//        while (fileIter.hasNext()) {
//            MultipartFile mFile = mptRequest.getFile(fileIter.next());
//            if (mFile.getSize() > 0L) {
//                long maxFileSize = Long.valueOf(EgovProperties.getProperty("Globals.imageUploadSize")).longValue();
//                if (mFile.getSize() > maxFileSize)
//                    throw new FileException("fileError");
//                HashMap<String, String> map = EgovFileMngUtil.uploadFile(mFile, uploadFilePath);
//                fileName = map.get("originalFileName");
//                filePath = (String)map.get("filePath") + File.separator + (String)map.get("uploadFileName");
//                fileId = ((String)map.get("uploadFileName")).substring(4).replaceAll("." + (String)map.get("fileExtension"), "");
//                uploadFileName = map.get("uploadFileName");
//                JFileVO fileVo = new JFileVO();
//                fileVo.setFilePath(PropertiesByStage.IMAGE_UPLOAD_PATH + File.separator + uploadFileName);
//                fileVo.setFileSize(Long.parseLong(map.get("fileSize")));
//                fileVo.setFileName(fileName);
//                fileVo.setFileMask(uploadFileName);
//                fileVo.setFileId(fileId);
//                String latestFileId = this.jFileService.addAttachFile((JFileDetails)fileVo);
//                codeVo.setProperty1(latestFileId);
//                modifyCode(codeVo);
//                this.logger.debug("[ filePath : " + filePath + " ]");
//                this.logger.debug("[ fileSize : " + (String)map.get("fileSize") + " ]");
//                this.logger.debug("[ originalFileName : " + fileName + " ]");
//                this.logger.debug("[ uploadFileName : " + uploadFileName + " ]");
//                this.logger.debug("[ fileExtension : " + (String)map.get("fileExtension") + " ]");
//            }
//        }
        return "Y";
    }

    public String modifySnsInfo(CodeVo codeVo, HttpServletRequest request) throws Exception {
        codeVo.setCodeDesc(codeVo.getCodeName());
        modifyCode(codeVo);
        return uploadSnsImage(codeVo, request);
    }

    public List<UrlLinkVo> getSnsLinkList(UrlLinkVo linkVo) throws Exception {
        List<UrlLinkVo> snsLinkList = this.adminBrandMapper.getSnsLinkList(linkVo);
//        for (UrlLinkVo link : snsLinkList) {
//            if (link.getFilePath() != null && !"".equals(link.getFilePath())) {
//                String filePath = ImageUtil.getImagePath(link.getFilePath());
//                link.setFilePath(filePath);
//            }
//        }
        return snsLinkList;
    }

    public void modifyImageFileInfo(ImageFileVo imageVo) {
        this.adminBrandMapper.modifyImageFileInfo(imageVo);
    }

    public int getCodeListCnt(CodeVo codeVo) {
        return this.adminBrandMapper.getCodeListCnt(codeVo);
    }
}
