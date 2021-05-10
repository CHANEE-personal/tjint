package com.tjint.springboot.app.admin.brand.service;

import com.tjint.springboot.common.CodeVo;

public class SnsInfoVo extends CodeVo {
    private static final long serialVersionUID = 1L;

    private String fileName;

    private String filePath;

    private String creatorName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SnsInfoVo))
            return false;
        SnsInfoVo other = (SnsInfoVo)o;
        if (!other.canEqual(this))
            return false;
        Object this$fileName = getFileName(), other$fileName = other.getFileName();
        if ((this$fileName == null) ? (other$fileName != null) : !this$fileName.equals(other$fileName))
            return false;
        Object this$filePath = getFilePath(), other$filePath = other.getFilePath();
        if ((this$filePath == null) ? (other$filePath != null) : !this$filePath.equals(other$filePath))
            return false;
        Object this$creatorName = getCreatorName(), other$creatorName = other.getCreatorName();
        return !((this$creatorName == null) ? (other$creatorName != null) : !this$creatorName.equals(other$creatorName));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SnsInfoVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $fileName = getFileName();
        result = result * 59 + (($fileName == null) ? 43 : $fileName.hashCode());
        Object $filePath = getFilePath();
        result = result * 59 + (($filePath == null) ? 43 : $filePath.hashCode());
        Object $creatorName = getCreatorName();
        return result * 59 + (($creatorName == null) ? 43 : $creatorName.hashCode());
    }

    public String toString() {
        return "SnsInfoVo(fileName=" + getFileName() + ", filePath=" + getFilePath() + ", creatorName=" + getCreatorName() + ")";
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getCreatorName() {
        return this.creatorName;
    }
}
