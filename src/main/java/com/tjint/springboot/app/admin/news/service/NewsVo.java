package com.tjint.springboot.app.admin.news.service;

import com.tjint.springboot.common.SearchDefaultVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;

public class NewsVo extends SearchDefaultVo {
    private static final long serialVersionUID = 1L;

    private Integer newsSeq;

    private String newsTitle;

    private String newsDescription;

    private ImageFileVo newsImage = new ImageFileVo();

//    private JFileVO jfile = new JFileVO();
//
//    public String getFileName() {
//        return this.jfile.getFileName();
//    }
//
//    public void setFileName(String fileName) {
//        this.jfile.setFileName(fileName);
//    }
//
//    public String getFilePath() {
//        return this.jfile.getFilePath();
//    }
//
//    public void setFilePath(String filePath) {
//        this.jfile.setFilePath(filePath);
//    }

    public String getImageFileId() {
        return this.newsImage.getImageFileId();
    }

    public void setImageFileId(String imagesFileId) {
        this.newsImage.setImageFileId(imagesFileId);
    }

    public Integer getNewsSeq() {
        return this.newsSeq;
    }

    public void setNewsSeq(Integer newsSeq) {
        this.newsSeq = newsSeq;
    }

    public String getNewsTitle() {
        return this.newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return this.newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public ImageFileVo getNewsImage() {
        return this.newsImage;
    }

    public void setNewsImage(ImageFileVo newsImage) {
        this.newsImage = newsImage;
    }

//    public JFileVO getJfile() {
//        return this.jfile;
//    }
//
//    public void setJfile(JFileVO jfile) {
//        this.jfile = jfile;
//    }

    public static long getSerialversionuid() {
        return 1L;
    }
}
