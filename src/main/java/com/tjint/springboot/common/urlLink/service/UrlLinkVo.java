package com.tjint.springboot.common.urlLink.service;

import com.tjint.springboot.common.SearchDefaultVo;

public class UrlLinkVo extends SearchDefaultVo {
    private static final long serialVersionUID = 1L;

    private String snsName;

    private Integer linkSeq;

    private String boardTypeCd;

    private Integer boardSeq;

    private String linkTypeCd;

    private String linkAddress;

    private Integer sortOrder;

    private String fileId;

    private String fileName;

    private String filePath;

    private String codeVisible;

    public void setSnsName(String snsName) {
        this.snsName = snsName;
    }

    public void setLinkSeq(Integer linkSeq) {
        this.linkSeq = linkSeq;
    }

    public void setBoardTypeCd(String boardTypeCd) {
        this.boardTypeCd = boardTypeCd;
    }

    public void setBoardSeq(Integer boardSeq) {
        this.boardSeq = boardSeq;
    }

    public void setLinkTypeCd(String linkTypeCd) {
        this.linkTypeCd = linkTypeCd;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setCodeVisible(String codeVisible) {
        this.codeVisible = codeVisible;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UrlLinkVo))
            return false;
        UrlLinkVo other = (UrlLinkVo)o;
        if (!other.canEqual(this))
            return false;
        Object this$snsName = getSnsName(), other$snsName = other.getSnsName();
        if ((this$snsName == null) ? (other$snsName != null) : !this$snsName.equals(other$snsName))
            return false;
        Object this$linkSeq = getLinkSeq(), other$linkSeq = other.getLinkSeq();
        if ((this$linkSeq == null) ? (other$linkSeq != null) : !this$linkSeq.equals(other$linkSeq))
            return false;
        Object this$boardTypeCd = getBoardTypeCd(), other$boardTypeCd = other.getBoardTypeCd();
        if ((this$boardTypeCd == null) ? (other$boardTypeCd != null) : !this$boardTypeCd.equals(other$boardTypeCd))
            return false;
        Object this$boardSeq = getBoardSeq(), other$boardSeq = other.getBoardSeq();
        if ((this$boardSeq == null) ? (other$boardSeq != null) : !this$boardSeq.equals(other$boardSeq))
            return false;
        Object this$linkTypeCd = getLinkTypeCd(), other$linkTypeCd = other.getLinkTypeCd();
        if ((this$linkTypeCd == null) ? (other$linkTypeCd != null) : !this$linkTypeCd.equals(other$linkTypeCd))
            return false;
        Object this$linkAddress = getLinkAddress(), other$linkAddress = other.getLinkAddress();
        if ((this$linkAddress == null) ? (other$linkAddress != null) : !this$linkAddress.equals(other$linkAddress))
            return false;
        Object this$sortOrder = getSortOrder(), other$sortOrder = other.getSortOrder();
        if ((this$sortOrder == null) ? (other$sortOrder != null) : !this$sortOrder.equals(other$sortOrder))
            return false;
        Object this$fileId = getFileId(), other$fileId = other.getFileId();
        if ((this$fileId == null) ? (other$fileId != null) : !this$fileId.equals(other$fileId))
            return false;
        Object this$fileName = getFileName(), other$fileName = other.getFileName();
        if ((this$fileName == null) ? (other$fileName != null) : !this$fileName.equals(other$fileName))
            return false;
        Object this$filePath = getFilePath(), other$filePath = other.getFilePath();
        if ((this$filePath == null) ? (other$filePath != null) : !this$filePath.equals(other$filePath))
            return false;
        Object this$codeVisible = getCodeVisible(), other$codeVisible = other.getCodeVisible();
        return !((this$codeVisible == null) ? (other$codeVisible != null) : !this$codeVisible.equals(other$codeVisible));
    }

    protected boolean canEqual(Object other) {
        return other instanceof UrlLinkVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $snsName = getSnsName();
        result = result * 59 + (($snsName == null) ? 43 : $snsName.hashCode());
        Object $linkSeq = getLinkSeq();
        result = result * 59 + (($linkSeq == null) ? 43 : $linkSeq.hashCode());
        Object $boardTypeCd = getBoardTypeCd();
        result = result * 59 + (($boardTypeCd == null) ? 43 : $boardTypeCd.hashCode());
        Object $boardSeq = getBoardSeq();
        result = result * 59 + (($boardSeq == null) ? 43 : $boardSeq.hashCode());
        Object $linkTypeCd = getLinkTypeCd();
        result = result * 59 + (($linkTypeCd == null) ? 43 : $linkTypeCd.hashCode());
        Object $linkAddress = getLinkAddress();
        result = result * 59 + (($linkAddress == null) ? 43 : $linkAddress.hashCode());
        Object $sortOrder = getSortOrder();
        result = result * 59 + (($sortOrder == null) ? 43 : $sortOrder.hashCode());
        Object $fileId = getFileId();
        result = result * 59 + (($fileId == null) ? 43 : $fileId.hashCode());
        Object $fileName = getFileName();
        result = result * 59 + (($fileName == null) ? 43 : $fileName.hashCode());
        Object $filePath = getFilePath();
        result = result * 59 + (($filePath == null) ? 43 : $filePath.hashCode());
        Object $codeVisible = getCodeVisible();
        return result * 59 + (($codeVisible == null) ? 43 : $codeVisible.hashCode());
    }

    public String toString() {
        return "UrlLinkVo(snsName=" + getSnsName() + ", linkSeq=" + getLinkSeq() + ", boardTypeCd=" + getBoardTypeCd() + ", boardSeq=" + getBoardSeq() + ", linkTypeCd=" + getLinkTypeCd() + ", linkAddress=" + getLinkAddress() + ", sortOrder=" + getSortOrder() + ", fileId=" + getFileId() + ", fileName=" + getFileName() + ", filePath=" + getFilePath() + ", codeVisible=" + getCodeVisible() + ")";
    }

    public String getSnsName() {
        return this.snsName;
    }

    public Integer getLinkSeq() {
        return this.linkSeq;
    }

    public String getBoardTypeCd() {
        return this.boardTypeCd;
    }

    public Integer getBoardSeq() {
        return this.boardSeq;
    }

    public String getLinkTypeCd() {
        return this.linkTypeCd;
    }

    public String getLinkAddress() {
        return this.linkAddress;
    }

    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getCodeVisible() {
        return this.codeVisible;
    }
}
