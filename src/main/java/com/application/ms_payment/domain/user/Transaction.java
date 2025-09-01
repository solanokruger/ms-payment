package com.application.ms_payment.domain.user;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private String id;
    private BigDecimal value;
    private User user;
    private Date transactionDate;
    private String status;

}
