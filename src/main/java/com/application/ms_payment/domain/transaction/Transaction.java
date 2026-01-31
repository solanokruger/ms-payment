package com.application.ms_payment.domain.transaction;

import com.application.ms_payment.domain.user.User;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private String id;
    private BigDecimal value;
    private User payer;
    private User payee;
    private Date transactionDate;
    private String status;

    public Transaction() {
    }

    public Transaction(String id, BigDecimal value, User payer, User payee, Date transactionDate, String status) {
        this.id = id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getPayee() {
        return payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
