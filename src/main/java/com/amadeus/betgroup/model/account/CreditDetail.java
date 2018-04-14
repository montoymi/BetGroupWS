package com.amadeus.betgroup.model.account;

import java.util.Date;

public class CreditDetail {
    private Integer creditDetailId;
    private Integer transactionTypeId;
    private CreditTransactionType creditTransationType;
    private Date transactionDate;
    private Integer creditAmount;
    private Integer status;
    private String comments;
    private Integer userId;
    private Integer createdBy;
    private Date creationDate;
    private Integer lastUpdatedBy;
    private Date lastUpdatedDate;
    private User user;

    private Credit credit;

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreditTransactionType getCreditTransationType() {
        return creditTransationType;
    }

    public void setCreditTransationType(CreditTransactionType creditTransationType) {
        this.creditTransationType = creditTransationType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getCreditDetailId() {
        return creditDetailId;
    }

    public void setCreditDetailId(Integer creditDetailId) {
        this.creditDetailId = creditDetailId;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

  /*  public CreditTransactionType getCreditTransationType() {
        return creditTransationType;
    }

    public void setCreditTransationType(CreditTransactionType creditTransationType) {
        this.creditTransationType = creditTransationType;
    }
*/
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Integer creditAmount) {
        this.creditAmount = creditAmount;
    }

    public CreditDetail() {
    }
}
