package com.tjint.springboot.common;

import java.io.Serializable;

public class SearchDefaultVo extends BaseTableInfoVo implements Serializable {
    private static final long serialVersionUID = 4829684178121022508L;
    private String searchCondition;
    private String searchCondition2;
    private String searchKeyword;
    private String searchContentSeq;
    private String searchUseYn;
    private String orderCondition;
    private int pageIndex;
    private int pageUnit;
    private int pageSize;
    private int firstIndex;
    private int lastIndex;
    private int recordCountPerPage;
    private String resultValue;

    public SearchDefaultVo() {
        this.searchCondition = "";
        this.searchCondition2 = "";
        this.searchKeyword = "";
        this.searchContentSeq = "";
        this.searchUseYn = "";
        this.orderCondition = "";
        this.pageIndex = 1;
        this.pageUnit = 10;
        this.pageSize = 10;
        this.firstIndex = 1;
        this.lastIndex = 1;
        this.recordCountPerPage = 10;
        this.resultValue = "";
    }

    public String getSearchCondition() {
        return this.searchCondition;
    }

    public String getSearchCondition2() {
        return this.searchCondition2;
    }

    public String getSearchKeyword() {
        return this.searchKeyword;
    }

    public String getSearchContentSeq() {
        return this.searchContentSeq;
    }

    public String getSearchUseYn() {
        return this.searchUseYn;
    }

    public String getOrderCondition() {
        return this.orderCondition;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageUnit() {
        return this.pageUnit;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }

    public int getRecordCountPerPage() {
        return this.recordCountPerPage;
    }

    public String getResultValue() {
        return this.resultValue;
    }

    public void setSearchCondition(final String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public void setSearchCondition2(final String searchCondition2) {
        this.searchCondition2 = searchCondition2;
    }

    public void setSearchKeyword(final String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setSearchContentSeq(final String searchContentSeq) {
        this.searchContentSeq = searchContentSeq;
    }

    public void setSearchUseYn(final String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public void setOrderCondition(final String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public void setPageIndex(final int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageUnit(final int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setFirstIndex(final int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setLastIndex(final int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void setRecordCountPerPage(final int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    public void setResultValue(final String resultValue) {
        this.resultValue = resultValue;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SearchDefaultVo)) {
            return false;
        }
        final SearchDefaultVo other = (SearchDefaultVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$searchCondition = this.getSearchCondition();
        final Object other$searchCondition = other.getSearchCondition();
        Label_0065: {
            if (this$searchCondition == null) {
                if (other$searchCondition == null) {
                    break Label_0065;
                }
            }
            else if (this$searchCondition.equals(other$searchCondition)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$searchCondition2 = this.getSearchCondition2();
        final Object other$searchCondition2 = other.getSearchCondition2();
        Label_0102: {
            if (this$searchCondition2 == null) {
                if (other$searchCondition2 == null) {
                    break Label_0102;
                }
            }
            else if (this$searchCondition2.equals(other$searchCondition2)) {
                break Label_0102;
            }
            return false;
        }
        final Object this$searchKeyword = this.getSearchKeyword();
        final Object other$searchKeyword = other.getSearchKeyword();
        Label_0139: {
            if (this$searchKeyword == null) {
                if (other$searchKeyword == null) {
                    break Label_0139;
                }
            }
            else if (this$searchKeyword.equals(other$searchKeyword)) {
                break Label_0139;
            }
            return false;
        }
        final Object this$searchContentSeq = this.getSearchContentSeq();
        final Object other$searchContentSeq = other.getSearchContentSeq();
        Label_0176: {
            if (this$searchContentSeq == null) {
                if (other$searchContentSeq == null) {
                    break Label_0176;
                }
            }
            else if (this$searchContentSeq.equals(other$searchContentSeq)) {
                break Label_0176;
            }
            return false;
        }
        final Object this$searchUseYn = this.getSearchUseYn();
        final Object other$searchUseYn = other.getSearchUseYn();
        Label_0213: {
            if (this$searchUseYn == null) {
                if (other$searchUseYn == null) {
                    break Label_0213;
                }
            }
            else if (this$searchUseYn.equals(other$searchUseYn)) {
                break Label_0213;
            }
            return false;
        }
        final Object this$orderCondition = this.getOrderCondition();
        final Object other$orderCondition = other.getOrderCondition();
        Label_0250: {
            if (this$orderCondition == null) {
                if (other$orderCondition == null) {
                    break Label_0250;
                }
            }
            else if (this$orderCondition.equals(other$orderCondition)) {
                break Label_0250;
            }
            return false;
        }
        if (this.getPageIndex() != other.getPageIndex()) {
            return false;
        }
        if (this.getPageUnit() != other.getPageUnit()) {
            return false;
        }
        if (this.getPageSize() != other.getPageSize()) {
            return false;
        }
        if (this.getFirstIndex() != other.getFirstIndex()) {
            return false;
        }
        if (this.getLastIndex() != other.getLastIndex()) {
            return false;
        }
        if (this.getRecordCountPerPage() != other.getRecordCountPerPage()) {
            return false;
        }
        final Object this$resultValue = this.getResultValue();
        final Object other$resultValue = other.getResultValue();
        if (this$resultValue == null) {
            if (other$resultValue == null) {
                return true;
            }
        }
        else if (this$resultValue.equals(other$resultValue)) {
            return true;
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SearchDefaultVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $searchCondition = this.getSearchCondition();
        result = result * 59 + (($searchCondition == null) ? 43 : $searchCondition.hashCode());
        final Object $searchCondition2 = this.getSearchCondition2();
        result = result * 59 + (($searchCondition2 == null) ? 43 : $searchCondition2.hashCode());
        final Object $searchKeyword = this.getSearchKeyword();
        result = result * 59 + (($searchKeyword == null) ? 43 : $searchKeyword.hashCode());
        final Object $searchContentSeq = this.getSearchContentSeq();
        result = result * 59 + (($searchContentSeq == null) ? 43 : $searchContentSeq.hashCode());
        final Object $searchUseYn = this.getSearchUseYn();
        result = result * 59 + (($searchUseYn == null) ? 43 : $searchUseYn.hashCode());
        final Object $orderCondition = this.getOrderCondition();
        result = result * 59 + (($orderCondition == null) ? 43 : $orderCondition.hashCode());
        result = result * 59 + this.getPageIndex();
        result = result * 59 + this.getPageUnit();
        result = result * 59 + this.getPageSize();
        result = result * 59 + this.getFirstIndex();
        result = result * 59 + this.getLastIndex();
        result = result * 59 + this.getRecordCountPerPage();
        final Object $resultValue = this.getResultValue();
        result = result * 59 + (($resultValue == null) ? 43 : $resultValue.hashCode());
        return result;
    }

    public String toString() {
        return "SearchDefaultVo(searchCondition=" + this.getSearchCondition() + ", searchCondition2=" + this.getSearchCondition2() + ", searchKeyword=" + this.getSearchKeyword() + ", searchContentSeq=" + this.getSearchContentSeq() + ", searchUseYn=" + this.getSearchUseYn() + ", orderCondition=" + this.getOrderCondition() + ", pageIndex=" + this.getPageIndex() + ", pageUnit=" + this.getPageUnit() + ", pageSize=" + this.getPageSize() + ", firstIndex=" + this.getFirstIndex() + ", lastIndex=" + this.getLastIndex() + ", recordCountPerPage=" + this.getRecordCountPerPage() + ", resultValue=" + this.getResultValue() + ")";
    }
}
