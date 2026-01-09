package com.application.ms_payment.domain.transaction;

import com.application.ms_payment.domain.user.User;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private String id;
    private BigDecimal value;
    private User user;
    private Date transactionDate;
    private String status;

}
