package com.tjint.springboot.common;

public class CodeVo extends SearchDefaultVo{
    private static final long serialVersionUID = 1L;
    private String codeId;
    private String codeName;
    private String codeValue;
    private String codeDesc;
    private String parentCd;
    private String property1;
    private String property2;
    private String property3;
    private String property4;
    private String property5;
    private String sortOrder;

    public String getCodeId() {
        return this.codeId;
    }

    public void setCodeId(final String codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(final String codeName) {
        this.codeName = codeName;
    }

    public String getCodeValue() {
        return this.codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeDesc() {
        return this.codeDesc;
    }

    public void setCodeDesc(final String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public String getParentCd() {
        return this.parentCd;
    }

    public void setParentCd(final String parentCd) {
        this.parentCd = parentCd;
    }

    public String getProperty1() {
        return this.property1;
    }

    public void setProperty1(final String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return this.property2;
    }

    public void setProperty2(final String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return this.property3;
    }

    public void setProperty3(final String property3) {
        this.property3 = property3;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(final String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getProperty4() {
        return this.property4;
    }

    public void setProperty4(final String property4) {
        this.property4 = property4;
    }

    public String getProperty5() {
        return this.property5;
    }

    public void setProperty5(final String property5) {
        this.property5 = property5;
    }
}
