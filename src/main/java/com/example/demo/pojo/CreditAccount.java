package com.example.demo.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 征信报告中的信贷账户信息实体类
 * 对应模板中的 account1、account2 等账户数据
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CreditAccount {
    // 账户编号
    private String accountNo;
    // 管理机构
    private String managementOrg;
    // 账户标识
    private String accountTag;
    // 开立日期
    private LocalDate openDate;
    // 到期日期
    private LocalDate expireDate;
    // 借款金额（使用BigDecimal避免浮点精度问题）
    private BigDecimal loanAmount;
    // 账户币种
    private String currency;
    // 业务种类（如：其他个人消费贷款、个人汽车消费贷款）
    private String businessType;
    // 担保方式
    private String guaranteeType;
    // 还款期数
    private Integer repaymentTerms;
    // 还款频率（如：月）
    private String repaymentFreq;
    // 还款方式
    private String repaymentMethod;
    // 共同借款标志
    private String jointBorrowFlag;
    // 账户状态（如：结清）
    private String accountStatus;
    // 最新还款记录日期
    private LocalDate lastRecordDate;
    // 账户关闭日期
    private LocalDate closeDate;
    // 授信协议标识
    private String creditAgreementNo;

    // 无参构造函数（框架反序列化/实例化需要）
    public CreditAccount() {
    }

    // 全参构造函数（方便快速创建对象）
    public CreditAccount(String accountNo, String managementOrg, String accountTag, LocalDate openDate,
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

    // Getter和Setter方法（用于Thymeleaf取值/后端赋值）
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

    // toString方法（方便日志打印和调试）
    @Override
    public String toString() {
        return "CreditAccount{" +
                "accountNo='" + accountNo + '\'' +
                ", managementOrg='" + managementOrg + '\'' +
                ", accountTag='" + accountTag + '\'' +
                ", openDate=" + openDate +
                ", expireDate=" + expireDate +
                ", loanAmount=" + loanAmount +
                ", currency='" + currency + '\'' +
                ", businessType='" + businessType + '\'' +
                ", guaranteeType='" + guaranteeType + '\'' +
                ", repaymentTerms=" + repaymentTerms +
                ", repaymentFreq='" + repaymentFreq + '\'' +
                ", repaymentMethod='" + repaymentMethod + '\'' +
                ", jointBorrowFlag='" + jointBorrowFlag + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", lastRecordDate=" + lastRecordDate +
                ", closeDate=" + closeDate +
                ", creditAgreementNo='" + creditAgreementNo + '\'' +
                '}';
    }
}