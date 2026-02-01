package com.application.ms_payment.adapters.inbound.controllers;

import com.application.ms_payment.application.service.TransactionServiceImpl;
import com.application.ms_payment.application.service.UserServiceImpl;
import com.application.ms_payment.domain.transaction.Transaction;
import com.application.ms_payment.domain.transaction.TransactionRequestDTO;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfer")
public class TransactionsController {

    private final TransactionServiceImpl transactionService;


    @PostMapping
    public ResponseEntity<Transaction> transfer(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = this.transactionService.createTransaction(transactionRequestDTO);
        return ResponseEntity.created(null).body(transaction);
    }

}