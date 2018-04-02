package com.amadeus.betgroup.model.account;

public class CreditTransactionType {
    private Integer transactionTypeId;
    private String transactionTypeCode;
    private char transactionSign;
    private String description;

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public char getTransactionSign() {
        return transactionSign;
    }

    public void setTransactionSign(char transactionSign) {
        this.transactionSign = transactionSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
