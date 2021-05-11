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
    private String menuCategoryCd;
    private String menuCategoryNm;

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

    public String getMenuCategoryCd() {
        return this.menuCategoryCd;
    }

    public String getMenuCategoryNm() {
        return this.menuCategoryNm;
    }

    public void setBrandSeq(final Integer brandSeq) {
        this.brandSeq = brandSeq;
    }

    public void setCategoryCd(final String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryList(final List<SnsInfoVo> categoryList) {
        this.categoryList = categoryList;
    }

    public void setCategoryOrder(final Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public void setBrandName(final String brandName) {
        this.brandName = brandName;
    }

    public void setBrandDescription(final String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public void setBrandImage(final ImageFileVo brandImage) {
        this.brandImage = brandImage;
    }

    public void setBrandImageName(final String brandImageName) {
        this.brandImageName = brandImageName;
    }

    public void setBrandImagePath(final String brandImagePath) {
        this.brandImagePath = brandImagePath;
    }

    public void setSubImageList(final List<ImageFileVo> subImageList) {
        this.subImageList = subImageList;
    }

    public void setBrandUrlLink(final UrlLinkVo brandUrlLink) {
        this.brandUrlLink = brandUrlLink;
    }

    public void setBrandLinkAddress(final String brandLinkAddress) {
        this.brandLinkAddress = brandLinkAddress;
    }

    public void setSnsUrlLinkList(final List<UrlLinkVo> snsUrlLinkList) {
        this.snsUrlLinkList = snsUrlLinkList;
    }

    public void setMenuCategoryCd(final String menuCategoryCd) {
        this.menuCategoryCd = menuCategoryCd;
    }

    public void setMenuCategoryNm(final String menuCategoryNm) {
        this.menuCategoryNm = menuCategoryNm;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BrandVo)) {
            return false;
        }
        final BrandVo other = (BrandVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$brandSeq = this.getBrandSeq();
        final Object other$brandSeq = other.getBrandSeq();
        Label_0065: {
            if (this$brandSeq == null) {
                if (other$brandSeq == null) {
                    break Label_0065;
                }
            }
            else if (this$brandSeq.equals(other$brandSeq)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$categoryCd = this.getCategoryCd();
        final Object other$categoryCd = other.getCategoryCd();
        Label_0102: {
            if (this$categoryCd == null) {
                if (other$categoryCd == null) {
                    break Label_0102;
                }
            }
            else if (this$categoryCd.equals(other$categoryCd)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$categoryName = this.getCategoryName();
        final Object other$categoryName = other.getCategoryName();
        Label_0139: {
            if (this$categoryName == null) {
                if (other$categoryName == null) {
                    break Label_0139;
                }
            }
            else if (this$categoryName.equals(other$categoryName)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$categoryList = this.getCategoryList();
        final Object other$categoryList = other.getCategoryList();
        Label_0176: {
            if (this$categoryList == null) {
                if (other$categoryList == null) {
                    break Label_0176;
                }
            }
            else if (this$categoryList.equals(other$categoryList)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$categoryOrder = this.getCategoryOrder();
        final Object other$categoryOrder = other.getCategoryOrder();
        Label_0213: {
            if (this$categoryOrder == null) {
                if (other$categoryOrder == null) {
                    break Label_0213;
                }
            }
            else if (this$categoryOrder.equals(other$categoryOrder)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$brandName = this.getBrandName();
        final Object other$brandName = other.getBrandName();
        Label_0250: {
            if (this$brandName == null) {
                if (other$brandName == null) {
                    break Label_0250;
                }
            }
            else if (this$brandName.equals(other$brandName)) {
                break Label_0250;
            }
            return false;
        }
        final Object this$brandDescription = this.getBrandDescription();
        final Object other$brandDescription = other.getBrandDescription();
        Label_0287: {
            if (this$brandDescription == null) {
                if (other$brandDescription == null) {
                    break Label_0287;
                }
            }
            else if (this$brandDescription.equals(other$brandDescription)) {
                break Label_0287;
            }
            return false;
        }
        final Object this$brandImage = this.getBrandImage();
        final Object other$brandImage = other.getBrandImage();
        Label_0324: {
            if (this$brandImage == null) {
                if (other$brandImage == null) {
                    break Label_0324;
                }
            }
            else if (this$brandImage.equals(other$brandImage)) {
                break Label_0324;
            }
            return false;
        }
        final Object this$brandImageName = this.getBrandImageName();
        final Object other$brandImageName = other.getBrandImageName();
        Label_0361: {
            if (this$brandImageName == null) {
                if (other$brandImageName == null) {
                    break Label_0361;
                }
            }
            else if (this$brandImageName.equals(other$brandImageName)) {
                break Label_0361;
            }
            return false;
        }
        final Object this$brandImagePath = this.getBrandImagePath();
        final Object other$brandImagePath = other.getBrandImagePath();
        Label_0398: {
            if (this$brandImagePath == null) {
                if (other$brandImagePath == null) {
                    break Label_0398;
                }
            }
            else if (this$brandImagePath.equals(other$brandImagePath)) {
                break Label_0398;
            }
            return false;
        }
        final Object this$subImageList = this.getSubImageList();
        final Object other$subImageList = other.getSubImageList();
        Label_0435: {
            if (this$subImageList == null) {
                if (other$subImageList == null) {
                    break Label_0435;
                }
            }
            else if (this$subImageList.equals(other$subImageList)) {
                break Label_0435;
            }
            return false;
        }
        final Object this$brandUrlLink = this.getBrandUrlLink();
        final Object other$brandUrlLink = other.getBrandUrlLink();
        Label_0472: {
            if (this$brandUrlLink == null) {
                if (other$brandUrlLink == null) {
                    break Label_0472;
                }
            }
            else if (this$brandUrlLink.equals(other$brandUrlLink)) {
                break Label_0472;
            }
            return false;
        }
        final Object this$brandLinkAddress = this.getBrandLinkAddress();
        final Object other$brandLinkAddress = other.getBrandLinkAddress();
        Label_0509: {
            if (this$brandLinkAddress == null) {
                if (other$brandLinkAddress == null) {
                    break Label_0509;
                }
            }
            else if (this$brandLinkAddress.equals(other$brandLinkAddress)) {
                break Label_0509;
            }
            return false;
        }
        final Object this$snsUrlLinkList = this.getSnsUrlLinkList();
        final Object other$snsUrlLinkList = other.getSnsUrlLinkList();
        Label_0546: {
            if (this$snsUrlLinkList == null) {
                if (other$snsUrlLinkList == null) {
                    break Label_0546;
                }
            }
            else if (this$snsUrlLinkList.equals(other$snsUrlLinkList)) {
                break Label_0546;
            }
            return false;
        }
        final Object this$menuCategoryCd = this.getMenuCategoryCd();
        final Object other$menuCategoryCd = other.getMenuCategoryCd();
        Label_0583: {
            if (this$menuCategoryCd == null) {
                if (other$menuCategoryCd == null) {
                    break Label_0583;
                }
            }
            else if (this$menuCategoryCd.equals(other$menuCategoryCd)) {
                break Label_0583;
            }
            return false;
        }
        final Object this$menuCategoryNm = this.getMenuCategoryNm();
        final Object other$menuCategoryNm = other.getMenuCategoryNm();
        if (this$menuCategoryNm == null) {
            if (other$menuCategoryNm == null) {
                return true;
            }
        }
        else if (this$menuCategoryNm.equals(other$menuCategoryNm)) {
            return true;
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BrandVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $brandSeq = this.getBrandSeq();
        result = result * 59 + (($brandSeq == null) ? 43 : $brandSeq.hashCode());
        final Object $categoryCd = this.getCategoryCd();
        result = result * 59 + (($categoryCd == null) ? 43 : $categoryCd.hashCode());
        final Object $categoryName = this.getCategoryName();
        result = result * 59 + (($categoryName == null) ? 43 : $categoryName.hashCode());
        final Object $categoryList = this.getCategoryList();
        result = result * 59 + (($categoryList == null) ? 43 : $categoryList.hashCode());
        final Object $categoryOrder = this.getCategoryOrder();
        result = result * 59 + (($categoryOrder == null) ? 43 : $categoryOrder.hashCode());
        final Object $brandName = this.getBrandName();
        result = result * 59 + (($brandName == null) ? 43 : $brandName.hashCode());
        final Object $brandDescription = this.getBrandDescription();
        result = result * 59 + (($brandDescription == null) ? 43 : $brandDescription.hashCode());
        final Object $brandImage = this.getBrandImage();
        result = result * 59 + (($brandImage == null) ? 43 : $brandImage.hashCode());
        final Object $brandImageName = this.getBrandImageName();
        result = result * 59 + (($brandImageName == null) ? 43 : $brandImageName.hashCode());
        final Object $brandImagePath = this.getBrandImagePath();
        result = result * 59 + (($brandImagePath == null) ? 43 : $brandImagePath.hashCode());
        final Object $subImageList = this.getSubImageList();
        result = result * 59 + (($subImageList == null) ? 43 : $subImageList.hashCode());
        final Object $brandUrlLink = this.getBrandUrlLink();
        result = result * 59 + (($brandUrlLink == null) ? 43 : $brandUrlLink.hashCode());
        final Object $brandLinkAddress = this.getBrandLinkAddress();
        result = result * 59 + (($brandLinkAddress == null) ? 43 : $brandLinkAddress.hashCode());
        final Object $snsUrlLinkList = this.getSnsUrlLinkList();
        result = result * 59 + (($snsUrlLinkList == null) ? 43 : $snsUrlLinkList.hashCode());
        final Object $menuCategoryCd = this.getMenuCategoryCd();
        result = result * 59 + (($menuCategoryCd == null) ? 43 : $menuCategoryCd.hashCode());
        final Object $menuCategoryNm = this.getMenuCategoryNm();
        result = result * 59 + (($menuCategoryNm == null) ? 43 : $menuCategoryNm.hashCode());
        return result;
    }

    public String toString() {
        return "BrandVo(brandSeq=" + this.getBrandSeq() + ", categoryCd=" + this.getCategoryCd() + ", categoryName=" + this.getCategoryName() + ", categoryList=" + this.getCategoryList() + ", categoryOrder=" + this.getCategoryOrder() + ", brandName=" + this.getBrandName() + ", brandDescription=" + this.getBrandDescription() + ", brandImage=" + this.getBrandImage() + ", brandImageName=" + this.getBrandImageName() + ", brandImagePath=" + this.getBrandImagePath() + ", subImageList=" + this.getSubImageList() + ", brandUrlLink=" + this.getBrandUrlLink() + ", brandLinkAddress=" + this.getBrandLinkAddress() + ", snsUrlLinkList=" + this.getSnsUrlLinkList() + ", menuCategoryCd=" + this.getMenuCategoryCd() + ", menuCategoryNm=" + this.getMenuCategoryNm() + ")";
    }
}
