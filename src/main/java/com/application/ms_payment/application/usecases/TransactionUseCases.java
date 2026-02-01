package com.application.ms_payment.application.usecases;

import com.application.ms_payment.domain.transaction.Transaction;
import com.application.ms_payment.domain.transaction.TransactionRequestDTO;

public interface TransactionUseCases {

    Transaction createTransaction(TransactionRequestDTO transactionRequestDTO);
}
