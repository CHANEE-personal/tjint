package com.tjint.springboot.common;

import com.tjint.springboot.app.admin.brand.service.BrandVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;

public class BrandInfoVo extends BrandVo {
    private static final long serialVersionUID = 1L;

    private String brandLinkVisible;

    private String brandLink;

    private String snsLinks;

    ImageFileVo imageFileVo = new ImageFileVo();

    UrlLinkVo linkVo = new UrlLinkVo();

    public Integer getImageFileInfoSeq() {
        return this.imageFileVo.getImageFileInfoSeq();
    }

    public void setImageFileInfoSeq(Integer imageFileInfoSeq) {
        this.imageFileVo.setImageFileInfoSeq(imageFileInfoSeq);
    }

    public String getImageTypeCd() {
        return this.imageFileVo.getImageTypeCd();
    }

    public void setImageTypeCd(String imageTypeCd) {
        this.imageFileVo.setImageTypeCd(imageTypeCd);
    }

    public String getImageFileId() {
        return this.imageFileVo.getImageFileId();
    }

    public void setImageFileId(String imageFileId) {
        this.imageFileVo.setImageFileId(imageFileId);
    }

    public Integer getImageFileSeq() {
        return this.imageFileVo.getImageFileSeq();
    }

    public void setImageFileSeq(Integer imageFileSeq) {
        this.imageFileVo.setImageFileSeq(imageFileSeq);
    }

    public String getImageFileName() {
        return this.imageFileVo.getImageFileName();
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileVo.setImageFileName(imageFileName);
    }

    public Integer getLinkSeq() {
        return this.linkVo.getLinkSeq();
    }

    public void setLinkSeq(Integer linkSeq) {
        this.linkVo.setLinkSeq(linkSeq);
    }

    public String getBoardTypeCd() {
        return this.linkVo.getBoardTypeCd();
    }

    public void setBoardTypeCd(String boardTypeCd) {
        this.linkVo.setBoardTypeCd(boardTypeCd);
    }

    public Integer getBoardSeq() {
        return this.linkVo.getBoardSeq();
    }

    public void setBoardSeq(Integer boardSeq) {
        this.linkVo.setBoardSeq(boardSeq);
    }

    public String getLinkTypeCd() {
        return this.linkVo.getLinkTypeCd();
    }

    public void setLinkTypeCd(String linkTypeCd) {
        this.linkVo.setLinkTypeCd(linkTypeCd);
    }

    public String getLinkAddress() {
        return this.linkVo.getLinkAddress();
    }

    public void setLinkAddress(String linkAddress) {
        this.linkVo.setLinkAddress(linkAddress);
    }

    public String getBrandLinkVisible() {
        return this.brandLinkVisible;
    }

    public void setBrandLinkVisible(String brandLinkVisible) {
        this.brandLinkVisible = brandLinkVisible;
    }

    public String getBrandLink() {
        return this.brandLink;
    }

    public void setBrandLink(String brandLink) {
        this.brandLink = brandLink;
    }

    public String getSnsLinks() {
        return this.snsLinks;
    }

    public void setSnsLinks(String snsLinks) {
        this.snsLinks = snsLinks;
    }
}
