package com.application.ms_payment.domain.user;

import java.math.BigDecimal;

public class Wallet {

    private Long id;
    private BigDecimal currency;

    public Wallet() {
    }

    public Wallet(Long id, BigDecimal currency) {
        this.id = id;
        this.currency = currency;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
