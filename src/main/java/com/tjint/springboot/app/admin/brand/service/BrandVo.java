package com.tjint.springboot.app.admin.brand.service;

import com.tjint.springboot.common.SearchDefaultVo;
import com.tjint.springboot.common.imageFile.service.ImageFileVo;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;

import java.util.List;

public class BrandVo extends SearchDefaultVo {
    private static final long serialVersionUID = 1L;

    private Integer brandSeq;

    private String categoryCd;

    private String categoryName;

    private List<SnsInfoVo> categoryList;

    private Integer categoryOrder;

    private String brandName;

    private String brandDescription;

    private ImageFileVo brandImage;

    private String brandImageName;

    private String brandImagePath;

    private List<ImageFileVo> subImageList;

    private UrlLinkVo brandUrlLink;

    private String brandLinkAddress;

    private List<UrlLinkVo> snsUrlLinkList;

    public void setBrandSeq(Integer brandSeq) {
        this.brandSeq = brandSeq;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryList(List<SnsInfoVo> categoryList) {
        this.categoryList = categoryList;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public void setBrandImage(ImageFileVo brandImage) {
        this.brandImage = brandImage;
    }

    public void setBrandImageName(String brandImageName) {
        this.brandImageName = brandImageName;
    }

    public void setBrandImagePath(String brandImagePath) {
        this.brandImagePath = brandImagePath;
    }

    public void setSubImageList(List<ImageFileVo> subImageList) {
        this.subImageList = subImageList;
    }

    public void setBrandUrlLink(UrlLinkVo brandUrlLink) {
        this.brandUrlLink = brandUrlLink;
    }

    public void setBrandLinkAddress(String brandLinkAddress) {
        this.brandLinkAddress = brandLinkAddress;
    }

    public void setSnsUrlLinkList(List<UrlLinkVo> snsUrlLinkList) {
        this.snsUrlLinkList = snsUrlLinkList;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BrandVo))
            return false;
        BrandVo other = (BrandVo)o;
        if (!other.canEqual(this))
            return false;
        Object this$brandSeq = getBrandSeq(), other$brandSeq = other.getBrandSeq();
        if ((this$brandSeq == null) ? (other$brandSeq != null) : !this$brandSeq.equals(other$brandSeq))
            return false;
        Object this$categoryCd = getCategoryCd(), other$categoryCd = other.getCategoryCd();
        if ((this$categoryCd == null) ? (other$categoryCd != null) : !this$categoryCd.equals(other$categoryCd))
            return false;
        Object this$categoryName = getCategoryName(), other$categoryName = other.getCategoryName();
        if ((this$categoryName == null) ? (other$categoryName != null) : !this$categoryName.equals(other$categoryName))
            return false;
        Object this$categoryList = getCategoryList(), other$categoryList = other.getCategoryList();
        if ((this$categoryList == null) ? (other$categoryList != null) : !this$categoryList.equals(other$categoryList))
            return false;
        Object this$categoryOrder = getCategoryOrder(), other$categoryOrder = other.getCategoryOrder();
        if ((this$categoryOrder == null) ? (other$categoryOrder != null) : !this$categoryOrder.equals(other$categoryOrder))
            return false;
        Object this$brandName = getBrandName(), other$brandName = other.getBrandName();
        if ((this$brandName == null) ? (other$brandName != null) : !this$brandName.equals(other$brandName))
            return false;
        Object this$brandDescription = getBrandDescription(), other$brandDescription = other.getBrandDescription();
        if ((this$brandDescription == null) ? (other$brandDescription != null) : !this$brandDescription.equals(other$brandDescription))
            return false;
        Object this$brandImage = getBrandImage(), other$brandImage = other.getBrandImage();
        if ((this$brandImage == null) ? (other$brandImage != null) : !this$brandImage.equals(other$brandImage))
            return false;
        Object this$brandImageName = getBrandImageName(), other$brandImageName = other.getBrandImageName();
        if ((this$brandImageName == null) ? (other$brandImageName != null) : !this$brandImageName.equals(other$brandImageName))
            return false;
        Object this$brandImagePath = getBrandImagePath(), other$brandImagePath = other.getBrandImagePath();
        if ((this$brandImagePath == null) ? (other$brandImagePath != null) : !this$brandImagePath.equals(other$brandImagePath))
            return false;
        Object this$subImageList = getSubImageList(), other$subImageList = other.getSubImageList();
        if ((this$subImageList == null) ? (other$subImageList != null) : !this$subImageList.equals(other$subImageList))
            return false;
        Object this$brandUrlLink = getBrandUrlLink(), other$brandUrlLink = other.getBrandUrlLink();
        if ((this$brandUrlLink == null) ? (other$brandUrlLink != null) : !this$brandUrlLink.equals(other$brandUrlLink))
            return false;
        Object this$brandLinkAddress = getBrandLinkAddress(), other$brandLinkAddress = other.getBrandLinkAddress();
        if ((this$brandLinkAddress == null) ? (other$brandLinkAddress != null) : !this$brandLinkAddress.equals(other$brandLinkAddress))
            return false;
        Object this$snsUrlLinkList = getSnsUrlLinkList(), other$snsUrlLinkList = other.getSnsUrlLinkList();
        return !((this$snsUrlLinkList == null) ? (other$snsUrlLinkList != null) : !this$snsUrlLinkList.equals(other$snsUrlLinkList));
    }

    protected boolean canEqual(Object other) {
        return other instanceof BrandVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $brandSeq = getBrandSeq();
        result = result * 59 + (($brandSeq == null) ? 43 : $brandSeq.hashCode());
        Object $categoryCd = getCategoryCd();
        result = result * 59 + (($categoryCd == null) ? 43 : $categoryCd.hashCode());
        Object $categoryName = getCategoryName();
        result = result * 59 + (($categoryName == null) ? 43 : $categoryName.hashCode());
        Object $categoryList = getCategoryList();
        result = result * 59 + (($categoryList == null) ? 43 : $categoryList.hashCode());
        Object $categoryOrder = getCategoryOrder();
        result = result * 59 + (($categoryOrder == null) ? 43 : $categoryOrder.hashCode());
        Object $brandName = getBrandName();
        result = result * 59 + (($brandName == null) ? 43 : $brandName.hashCode());
        Object $brandDescription = getBrandDescription();
        result = result * 59 + (($brandDescription == null) ? 43 : $brandDescription.hashCode());
        Object $brandImage = getBrandImage();
        result = result * 59 + (($brandImage == null) ? 43 : $brandImage.hashCode());
        Object $brandImageName = getBrandImageName();
        result = result * 59 + (($brandImageName == null) ? 43 : $brandImageName.hashCode());
        Object $brandImagePath = getBrandImagePath();
        result = result * 59 + (($brandImagePath == null) ? 43 : $brandImagePath.hashCode());
        Object $subImageList = getSubImageList();
        result = result * 59 + (($subImageList == null) ? 43 : $subImageList.hashCode());
        Object $brandUrlLink = getBrandUrlLink();
        result = result * 59 + (($brandUrlLink == null) ? 43 : $brandUrlLink.hashCode());
        Object $brandLinkAddress = getBrandLinkAddress();
        result = result * 59 + (($brandLinkAddress == null) ? 43 : $brandLinkAddress.hashCode());
        Object $snsUrlLinkList = getSnsUrlLinkList();
        return result * 59 + (($snsUrlLinkList == null) ? 43 : $snsUrlLinkList.hashCode());
    }

    public String toString() {
        return "BrandVo(brandSeq=" + getBrandSeq() + ", categoryCd=" + getCategoryCd() + ", categoryName=" + getCategoryName() + ", categoryList=" + getCategoryList() + ", categoryOrder=" + getCategoryOrder() + ", brandName=" + getBrandName() + ", brandDescription=" + getBrandDescription() + ", brandImage=" + getBrandImage() + ", brandImageName=" + getBrandImageName() + ", brandImagePath=" + getBrandImagePath() + ", subImageList=" + getSubImageList() + ", brandUrlLink=" + getBrandUrlLink() + ", brandLinkAddress=" + getBrandLinkAddress() + ", snsUrlLinkList=" + getSnsUrlLinkList() + ")";
    }

    public Integer getBrandSeq() {
        return this.brandSeq;
    }

    public String getCategoryCd() {
        return this.categoryCd;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<SnsInfoVo> getCategoryList() {
        return this.categoryList;
    }

    public Integer getCategoryOrder() {
        return this.categoryOrder;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getBrandDescription() {
        return this.brandDescription;
    }

    public ImageFileVo getBrandImage() {
        return this.brandImage;
    }

    public String getBrandImageName() {
        return this.brandImageName;
    }

    public String getBrandImagePath() {
        return this.brandImagePath;
    }

    public List<ImageFileVo> getSubImageList() {
        return this.subImageList;
    }

    public UrlLinkVo getBrandUrlLink() {
        return this.brandUrlLink;
    }

    public String getBrandLinkAddress() {
        return this.brandLinkAddress;
    }

    public List<UrlLinkVo> getSnsUrlLinkList() {
        return this.snsUrlLinkList;
    }
}
