package com.example.demo.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 征信报告 - 信贷账户信息实体类
 * 适配Thymeleaf模板中account1/account2的所有字段
 */
public class CreditAccount2 {
    // 基础字段（延续之前的核心字段）
    private String accountNo;          // 账户编号
    private String managementOrg;      // 管理机构
    private String accountTag;         // 账户标识
    private LocalDate openDate;        // 开立日期
    private LocalDate expireDate;      // 到期日期
    private BigDecimal loanAmount;     // 借款金额（金融场景用BigDecimal避免精度问题）
    private String currency;           // 账户币种
    
    // 本次补充的核心字段
    private String businessType;       // 业务种类（如：其他个人消费贷款、个人汽车消费贷款）
    private String guaranteeType;      // 担保方式（如：抵押）
    private Integer repaymentTerms;    // 还款期数（如：12）
    private String repaymentFreq;      // 还款频率（如：月）
    private String repaymentMethod;    // 还款方式（如：-）
    private String jointBorrowFlag;    // 共同借款标志（如：无）
    
    // 其他关联字段（保证模板完整适配）
    private String accountStatus;      // 账户状态
    private LocalDate lastRecordDate;  // 最新还款记录日期
    private LocalDate closeDate;       // 账户关闭日期
    private String creditAgreementNo;  // 授信协议标识

    // 无参构造函数（框架实例化、反序列化必备）
    public CreditAccount2() {
    }

    // 全参构造函数（方便快速创建对象）
    public CreditAccount2(String accountNo, String managementOrg, String accountTag, LocalDate openDate,
                         LocalDate expireDate, BigDecimal loanAmount, String currency, String businessType,
                         String guaranteeType, Integer repaymentTerms, String repaymentFreq, String repaymentMethod,
                         String jointBorrowFlag, String accountStatus, LocalDate lastRecordDate, LocalDate closeDate,
                         String creditAgreementNo) {
        this.accountNo = accountNo;
        this.managementOrg = managementOrg;
        this.accountTag = accountTag;
        this.openDate = openDate;
        this.expireDate = expireDate;
        this.loanAmount = loanAmount;
        this.currency = currency;
        this.businessType = businessType;
        this.guaranteeType = guaranteeType;
        this.repaymentTerms = repaymentTerms;
        this.repaymentFreq = repaymentFreq;
        this.repaymentMethod = repaymentMethod;
        this.jointBorrowFlag = jointBorrowFlag;
        this.accountStatus = accountStatus;
        this.lastRecordDate = lastRecordDate;
        this.closeDate = closeDate;
        this.creditAgreementNo = creditAgreementNo;
    }

    // 所有字段的Getter/Setter方法（Thymeleaf取值、后端赋值必备）
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getManagementOrg() {
        return managementOrg;
    }

    public void setManagementOrg(String managementOrg) {
        this.managementOrg = managementOrg;
    }

    public String getAccountTag() {
        return accountTag;
    }

    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // 本次补充字段的Getter/Setter
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public Integer getRepaymentTerms() {
        return repaymentTerms;
    }

    public void setRepaymentTerms(Integer repaymentTerms) {
        this.repaymentTerms = repaymentTerms;
    }

    public String getRepaymentFreq() {
        return repaymentFreq;
    }

    public void setRepaymentFreq(String repaymentFreq) {
        this.repaymentFreq = repaymentFreq;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    public String getJointBorrowFlag() {
        return jointBorrowFlag;
    }

    public void setJointBorrowFlag(String jointBorrowFlag) {
        this.jointBorrowFlag = jointBorrowFlag;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDate getLastRecordDate() {
        return lastRecordDate;
    }

    public void setLastRecordDate(LocalDate lastRecordDate) {
        this.lastRecordDate = lastRecordDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public String getCreditAgreementNo() {
        return creditAgreementNo;
    }

    public void setCreditAgreementNo(String creditAgreementNo) {
        this.creditAgreementNo = creditAgreementNo;
    }

    // toString方法（方便调试、日志打印）
    @Override
    public String toString() {
        return "CreditAccount2{" +
                "accountNo='" + accountNo + '\'' +
                ", managementOrg='" + managementOrg + '\'' +
                ", businessType='" + businessType + '\'' +
                ", guaranteeType='" + guaranteeType + '\'' +
                ", repaymentTerms=" + repaymentTerms +
                ", repaymentFreq='" + repaymentFreq + '\'' +
                ", jointBorrowFlag='" + jointBorrowFlag + '\'' +
                '}';
    }
}