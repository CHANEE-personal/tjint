package com.tjint.springboot.common.imageFile.service;

import com.tjint.springboot.common.SearchDefaultVo;

public class ImageFileVo extends SearchDefaultVo {
    private static final long serialVersionUID = 1L;

    private Integer imageFileInfoSeq;

    private String boardTypeCd;

    private Integer boardSeq;

    private String imageTypeCd;

    private String imageFileId;

    private Integer imageFileSeq;

    private String imageFileName;

    private String imageFilePath;

    private Integer sortOrder;

    public void setImageFileInfoSeq(Integer imageFileInfoSeq) {
        this.imageFileInfoSeq = imageFileInfoSeq;
    }

    public void setBoardTypeCd(String boardTypeCd) {
        this.boardTypeCd = boardTypeCd;
    }

    public void setBoardSeq(Integer boardSeq) {
        this.boardSeq = boardSeq;
    }

    public void setImageTypeCd(String imageTypeCd) {
        this.imageTypeCd = imageTypeCd;
    }

    public void setImageFileId(String imageFileId) {
        this.imageFileId = imageFileId;
    }

    public void setImageFileSeq(Integer imageFileSeq) {
        this.imageFileSeq = imageFileSeq;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ImageFileVo))
            return false;
        ImageFileVo other = (ImageFileVo)o;
        if (!other.canEqual(this))
            return false;
        Object this$imageFileInfoSeq = getImageFileInfoSeq(), other$imageFileInfoSeq = other.getImageFileInfoSeq();
        if ((this$imageFileInfoSeq == null) ? (other$imageFileInfoSeq != null) : !this$imageFileInfoSeq.equals(other$imageFileInfoSeq))
            return false;
        Object this$boardTypeCd = getBoardTypeCd(), other$boardTypeCd = other.getBoardTypeCd();
        if ((this$boardTypeCd == null) ? (other$boardTypeCd != null) : !this$boardTypeCd.equals(other$boardTypeCd))
            return false;
        Object this$boardSeq = getBoardSeq(), other$boardSeq = other.getBoardSeq();
        if ((this$boardSeq == null) ? (other$boardSeq != null) : !this$boardSeq.equals(other$boardSeq))
            return false;
        Object this$imageTypeCd = getImageTypeCd(), other$imageTypeCd = other.getImageTypeCd();
        if ((this$imageTypeCd == null) ? (other$imageTypeCd != null) : !this$imageTypeCd.equals(other$imageTypeCd))
            return false;
        Object this$imageFileId = getImageFileId(), other$imageFileId = other.getImageFileId();
        if ((this$imageFileId == null) ? (other$imageFileId != null) : !this$imageFileId.equals(other$imageFileId))
            return false;
        Object this$imageFileSeq = getImageFileSeq(), other$imageFileSeq = other.getImageFileSeq();
        if ((this$imageFileSeq == null) ? (other$imageFileSeq != null) : !this$imageFileSeq.equals(other$imageFileSeq))
            return false;
        Object this$imageFileName = getImageFileName(), other$imageFileName = other.getImageFileName();
        if ((this$imageFileName == null) ? (other$imageFileName != null) : !this$imageFileName.equals(other$imageFileName))
            return false;
        Object this$imageFilePath = getImageFilePath(), other$imageFilePath = other.getImageFilePath();
        if ((this$imageFilePath == null) ? (other$imageFilePath != null) : !this$imageFilePath.equals(other$imageFilePath))
            return false;
        Object this$sortOrder = getSortOrder(), other$sortOrder = other.getSortOrder();
        return !((this$sortOrder == null) ? (other$sortOrder != null) : !this$sortOrder.equals(other$sortOrder));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ImageFileVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $imageFileInfoSeq = getImageFileInfoSeq();
        result = result * 59 + (($imageFileInfoSeq == null) ? 43 : $imageFileInfoSeq.hashCode());
        Object $boardTypeCd = getBoardTypeCd();
        result = result * 59 + (($boardTypeCd == null) ? 43 : $boardTypeCd.hashCode());
        Object $boardSeq = getBoardSeq();
        result = result * 59 + (($boardSeq == null) ? 43 : $boardSeq.hashCode());
        Object $imageTypeCd = getImageTypeCd();
        result = result * 59 + (($imageTypeCd == null) ? 43 : $imageTypeCd.hashCode());
        Object $imageFileId = getImageFileId();
        result = result * 59 + (($imageFileId == null) ? 43 : $imageFileId.hashCode());
        Object $imageFileSeq = getImageFileSeq();
        result = result * 59 + (($imageFileSeq == null) ? 43 : $imageFileSeq.hashCode());
        Object $imageFileName = getImageFileName();
        result = result * 59 + (($imageFileName == null) ? 43 : $imageFileName.hashCode());
        Object $imageFilePath = getImageFilePath();
        result = result * 59 + (($imageFilePath == null) ? 43 : $imageFilePath.hashCode());
        Object $sortOrder = getSortOrder();
        return result * 59 + (($sortOrder == null) ? 43 : $sortOrder.hashCode());
    }

    public String toString() {
        return "ImageFileVo(imageFileInfoSeq=" + getImageFileInfoSeq() + ", boardTypeCd=" + getBoardTypeCd() + ", boardSeq=" + getBoardSeq() + ", imageTypeCd=" + getImageTypeCd() + ", imageFileId=" + getImageFileId() + ", imageFileSeq=" + getImageFileSeq() + ", imageFileName=" + getImageFileName() + ", imageFilePath=" + getImageFilePath() + ", sortOrder=" + getSortOrder() + ")";
    }

    public Integer getImageFileInfoSeq() {
        return this.imageFileInfoSeq;
    }

    public String getBoardTypeCd() {
        return this.boardTypeCd;
    }

    public Integer getBoardSeq() {
        return this.boardSeq;
    }

    public String getImageTypeCd() {
        return this.imageTypeCd;
    }

    public String getImageFileId() {
        return this.imageFileId;
    }

    public Integer getImageFileSeq() {
        return this.imageFileSeq;
    }

    public String getImageFileName() {
        return this.imageFileName;
    }

    public String getImageFilePath() {
        return this.imageFilePath;
    }

    public Integer getSortOrder() {
        return this.sortOrder;
    }
}
