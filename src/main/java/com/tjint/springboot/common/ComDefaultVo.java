package com.tjint.springboot.common;

import java.io.Serializable;

public class ComDefaultVo implements Serializable {
    private String searchCondition;
    private String searchKeyword;
    private String searchUseYn;
    private int pageIndex;
    private int pageUnit;
    private int pageSize;
    private int firstIndex;
    private int lastIndex;
    private int recordCountPerPage;
    private String searchKeywordFrom;
    private String searchKeywordTo;

    public ComDefaultVO() {
        this.searchCondition = "";
        this.searchKeyword = "";
        this.searchUseYn = "";
        this.pageIndex = 1;
        this.pageUnit = 10;
        this.pageSize = 10;
        this.firstIndex = 1;
        this.lastIndex = 1;
        this.recordCountPerPage = 10;
        this.searchKeywordFrom = "";
        this.searchKeywordTo = "";
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public void setFirstIndex(final int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }

    public void setLastIndex(final int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public int getRecordCountPerPage() {
        return this.recordCountPerPage;
    }

    public void setRecordCountPerPage(final int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    public String getSearchCondition() {
        return this.searchCondition;
    }

    public void setSearchCondition(final String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchKeyword() {
        return this.searchKeyword;
    }

    public void setSearchKeyword(final String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchUseYn() {
        return this.searchUseYn;
    }

    public void setSearchUseYn(final String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(final int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return this.pageUnit;
    }

    public void setPageUnit(final int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this);
    }

    public String getSearchKeywordFrom() {
        return this.searchKeywordFrom;
    }

    public void setSearchKeywordFrom(final String searchKeywordFrom) {
        this.searchKeywordFrom = searchKeywordFrom;
    }

    public String getSearchKeywordTo() {
        return this.searchKeywordTo;
    }

    public void setSearchKeywordTo(final String searchKeywordTo) {
        this.searchKeywordTo = searchKeywordTo;
    }
}
