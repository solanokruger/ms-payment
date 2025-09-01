package com.application.ms_payment.domain.user;

import java.math.BigDecimal;

public class Wallet {

    private String id;
    private BigDecimal currency;

    public Wallet() {
    }

    public Wallet(String id, BigDecimal currency) {
        this.id = id;
        this.currency = currency;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
