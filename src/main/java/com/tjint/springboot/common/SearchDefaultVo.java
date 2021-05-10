package com.tjint.springboot.common;

import java.io.Serializable;

public class SearchDefaultVo extends BaseTableInfoVo implements Serializable {
    private static final long serialVersionUID = 4829684178121022508L;

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public void setSearchCondition2(String searchCondition2) {
        this.searchCondition2 = searchCondition2;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public void setSearchContentSeq(String searchContentSeq) {
        this.searchContentSeq = searchContentSeq;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchDefaultVo))
            return false;
        SearchDefaultVo other = (SearchDefaultVo)o;
        if (!other.canEqual(this))
            return false;
        Object this$searchCondition = getSearchCondition(), other$searchCondition = other.getSearchCondition();
        if ((this$searchCondition == null) ? (other$searchCondition != null) : !this$searchCondition.equals(other$searchCondition))
            return false;
        Object this$searchCondition2 = getSearchCondition2(), other$searchCondition2 = other.getSearchCondition2();
        if ((this$searchCondition2 == null) ? (other$searchCondition2 != null) : !this$searchCondition2.equals(other$searchCondition2))
            return false;
        Object this$searchKeyword = getSearchKeyword(), other$searchKeyword = other.getSearchKeyword();
        if ((this$searchKeyword == null) ? (other$searchKeyword != null) : !this$searchKeyword.equals(other$searchKeyword))
            return false;
        Object this$searchContentSeq = getSearchContentSeq(), other$searchContentSeq = other.getSearchContentSeq();
        if ((this$searchContentSeq == null) ? (other$searchContentSeq != null) : !this$searchContentSeq.equals(other$searchContentSeq))
            return false;
        Object this$searchUseYn = getSearchUseYn(), other$searchUseYn = other.getSearchUseYn();
        if ((this$searchUseYn == null) ? (other$searchUseYn != null) : !this$searchUseYn.equals(other$searchUseYn))
            return false;
        Object this$orderCondition = getOrderCondition(), other$orderCondition = other.getOrderCondition();
        if ((this$orderCondition == null) ? (other$orderCondition != null) : !this$orderCondition.equals(other$orderCondition))
            return false;
        if (getPageIndex() != other.getPageIndex())
            return false;
        if (getPageUnit() != other.getPageUnit())
            return false;
        if (getPageSize() != other.getPageSize())
            return false;
        if (getFirstIndex() != other.getFirstIndex())
            return false;
        if (getLastIndex() != other.getLastIndex())
            return false;
        if (getRecordCountPerPage() != other.getRecordCountPerPage())
            return false;
        Object this$resultValue = getResultValue(), other$resultValue = other.getResultValue();
        return !((this$resultValue == null) ? (other$resultValue != null) : !this$resultValue.equals(other$resultValue));
    }

    protected boolean canEqual(Object other) {
        return other instanceof SearchDefaultVo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $searchCondition = getSearchCondition();
        result = result * 59 + (($searchCondition == null) ? 43 : $searchCondition.hashCode());
        Object $searchCondition2 = getSearchCondition2();
        result = result * 59 + (($searchCondition2 == null) ? 43 : $searchCondition2.hashCode());
        Object $searchKeyword = getSearchKeyword();
        result = result * 59 + (($searchKeyword == null) ? 43 : $searchKeyword.hashCode());
        Object $searchContentSeq = getSearchContentSeq();
        result = result * 59 + (($searchContentSeq == null) ? 43 : $searchContentSeq.hashCode());
        Object $searchUseYn = getSearchUseYn();
        result = result * 59 + (($searchUseYn == null) ? 43 : $searchUseYn.hashCode());
        Object $orderCondition = getOrderCondition();
        result = result * 59 + (($orderCondition == null) ? 43 : $orderCondition.hashCode());
        result = result * 59 + getPageIndex();
        result = result * 59 + getPageUnit();
        result = result * 59 + getPageSize();
        result = result * 59 + getFirstIndex();
        result = result * 59 + getLastIndex();
        result = result * 59 + getRecordCountPerPage();
        Object $resultValue = getResultValue();
        return result * 59 + (($resultValue == null) ? 43 : $resultValue.hashCode());
    }

    public String toString() {
        return "SearchDefaultVo(searchCondition=" + getSearchCondition() + ", searchCondition2=" + getSearchCondition2() + ", searchKeyword=" + getSearchKeyword() + ", searchContentSeq=" + getSearchContentSeq() + ", searchUseYn=" + getSearchUseYn() + ", orderCondition=" + getOrderCondition() + ", pageIndex=" + getPageIndex() + ", pageUnit=" + getPageUnit() + ", pageSize=" + getPageSize() + ", firstIndex=" + getFirstIndex() + ", lastIndex=" + getLastIndex() + ", recordCountPerPage=" + getRecordCountPerPage() + ", resultValue=" + getResultValue() + ")";
    }

    private String searchCondition = "";

    public String getSearchCondition() {
        return this.searchCondition;
    }

    private String searchCondition2 = "";

    public String getSearchCondition2() {
        return this.searchCondition2;
    }

    private String searchKeyword = "";

    public String getSearchKeyword() {
        return this.searchKeyword;
    }

    private String searchContentSeq = "";

    public String getSearchContentSeq() {
        return this.searchContentSeq;
    }

    private String searchUseYn = "";

    public String getSearchUseYn() {
        return this.searchUseYn;
    }

    private String orderCondition = "";

    public String getOrderCondition() {
        return this.orderCondition;
    }

    private int pageIndex = 1;

    public int getPageIndex() {
        return this.pageIndex;
    }

    private int pageUnit = 10;

    public int getPageUnit() {
        return this.pageUnit;
    }

    private int pageSize = 10;

    public int getPageSize() {
        return this.pageSize;
    }

    private int firstIndex = 1;

    public int getFirstIndex() {
        return this.firstIndex;
    }

    private int lastIndex = 1;

    public int getLastIndex() {
        return this.lastIndex;
    }

    private int recordCountPerPage = 10;

    public int getRecordCountPerPage() {
        return this.recordCountPerPage;
    }

    private String resultValue = "";

    public String getResultValue() {
        return this.resultValue;
    }
}
