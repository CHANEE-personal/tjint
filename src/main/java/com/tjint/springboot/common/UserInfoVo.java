package com.tjint.springboot.common;

public class UserInfoVo extends SearchDefaultVo{
    private static final long serialVersionUID = 1L;
    private Integer userSeq;
    private String userId;
    private String password;
    private String userTypeCd;
    private String name;
    private String phoneNo1;
    private String phoneNo2;
    private String phoneNo3;
    private String phoneNo4;
    private String email;
    private int entryInfoSeq;
    private int noticePolicySeq;
    private String noticeAgreement;
    private int policySeq;
    private String privacyAgreement;
    private String userType;
    private String userTitle;
    private String team;
    private String publisherCrn;
    private String start_work_date;
    private String employeeStatusCd;
    private String employeeStatus;
    private int monthVerificationTotal;
    private String judgeLevelCd;
    private String workYn;
    private String ssn1;
    private String ssn2;
    private String applicantTypeCd;

    public UserInfoVo() {
        this.userSeq = 0;
        this.policySeq = 0;
    }

    public String getWorkYn() {
        return this.workYn;
    }

    public void setWorkYn(final String workYn) {
        this.workYn = workYn;
    }

    public String getStart_work_date() {
        return this.start_work_date;
    }

    public void setStart_work_date(final String start_work_date) {
        this.start_work_date = start_work_date;
    }

    public void setUserSeq(final Integer userSeq) {
        this.userSeq = userSeq;
    }

    public String getEmployeeStatusCd() {
        return this.employeeStatusCd;
    }

    public void setEmployeeStatusCd(final String employeeStatusCd) {
        this.employeeStatusCd = employeeStatusCd;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getUserTypeCd() {
        return this.userTypeCd;
    }

    public void setUserTypeCd(final String userTypeCd) {
        this.userTypeCd = userTypeCd;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUserTitle() {
        return this.userTitle;
    }

    public void setUserTitle(final String userTitle) {
        this.userTitle = userTitle;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(final String team) {
        this.team = team;
    }

    public String getPublisherCrn() {
        return this.publisherCrn;
    }

    public void setPublisherCrn(final String publisherCrn) {
        this.publisherCrn = publisherCrn;
    }

    public String getPhoneNo1() {
        return this.phoneNo1;
    }

    public void setPhoneNo1(final String phoneNo1) {
        this.phoneNo1 = phoneNo1;
    }

    public String getPhoneNo2() {
        return this.phoneNo2;
    }

    public void setPhoneNo2(final String phoneNo2) {
        this.phoneNo2 = phoneNo2;
    }

    public String getPhoneNo3() {
        return this.phoneNo3;
    }

    public void setPhoneNo3(final String phoneNo3) {
        this.phoneNo3 = phoneNo3;
    }

    public String getPhoneNo4() {
        return this.phoneNo4;
    }

    public void setPhoneNo4(final String phoneNo4) {
        this.phoneNo4 = phoneNo4;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getPolicySeq() {
        return this.policySeq;
    }

    public void setPolicySeq(final Integer policySeq) {
        this.policySeq = policySeq;
    }

    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    public void setPrivacyAgreement(final String privacyAgreement) {
        this.privacyAgreement = privacyAgreement;
    }

    public String toString() {
        return "UserInfoVo [userId=" + this.userId + ", password=" + this.password + ", userTypeCd=" + this.userTypeCd + ", name=" + this.name + ", userTitle=" + this.userTitle + ", team=" + this.team + ", publisherCrn=" + this.publisherCrn + ", phoneNo1=" + this.phoneNo1 + ", phoneNo2=" + this.phoneNo2 + ", phoneNo3=" + this.phoneNo3 + ", phoneNo4=" + this.phoneNo4 + ", email=" + this.email + ", policySeq=" + this.policySeq + ", privacyAgreement=" + this.privacyAgreement + "]";
    }

    public int getUserSeq() {
        return this.userSeq;
    }

    public void setUserSeq(final int userSeq) {
        this.userSeq = userSeq;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

    public String getEmployeeStatus() {
        return this.employeeStatus;
    }

    public void setEmployeeStatus(final String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public int getMonthVerificationTotal() {
        return this.monthVerificationTotal;
    }

    public void setMonthVerificationTotal(final int monthVerificationTotal) {
        this.monthVerificationTotal = monthVerificationTotal;
    }

    public String getJudgeLevelCd() {
        return this.judgeLevelCd;
    }

    public void setJudgeLevelCd(final String judgeLevelCd) {
        this.judgeLevelCd = judgeLevelCd;
    }

    public String getSsn1() {
        return this.ssn1;
    }

    public void setSsn1(final String ssn1) {
        this.ssn1 = ssn1;
    }

    public String getSsn2() {
        return this.ssn2;
    }

    public void setSsn2(final String ssn2) {
        this.ssn2 = ssn2;
    }

    public String getApplicantTypeCd() {
        return this.applicantTypeCd;
    }

    public void setApplicantTypeCd(final String applicantTypeCd) {
        this.applicantTypeCd = applicantTypeCd;
    }

    public void setPolicySeq(final int policySeq) {
        this.policySeq = policySeq;
    }

    public int getEntryInfoSeq() {
        return this.entryInfoSeq;
    }

    public void setEntryInfoSeq(final int entryInfoSeq) {
        this.entryInfoSeq = entryInfoSeq;
    }

    public int getNoticePolicySeq() {
        return this.noticePolicySeq;
    }

    public void setNoticePolicySeq(final int noticePolicySeq) {
        this.noticePolicySeq = noticePolicySeq;
    }

    public String getNoticeAgreement() {
        return this.noticeAgreement;
    }

    public void setNoticeAgreement(final String noticeAgreement) {
        this.noticeAgreement = noticeAgreement;
    }
}
