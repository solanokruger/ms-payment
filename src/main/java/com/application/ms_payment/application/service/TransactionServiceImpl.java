package com.application.ms_payment.application.service;

import com.application.ms_payment.adapters.outbound.repositories.UserRepositoryImpl;
import com.application.ms_payment.application.usecases.TransactionUseCases;
import com.application.ms_payment.domain.transaction.Transaction;
import com.application.ms_payment.domain.transaction.TransactionRepository;
import com.application.ms_payment.domain.transaction.TransactionRequestDTO;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRepository;
import com.application.ms_payment.util.enums.UserRoleEnum;
import com.application.ms_payment.util.mappers.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionUseCases {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    @Override
    public Transaction createTransaction(TransactionRequestDTO transactionRequestDTO) {
        Optional<User> userPayee = userRepository.findById(transactionRequestDTO.payee());
        Optional<User> userPayer = userRepository.findById(transactionRequestDTO.payer());

        //todo: refactor to orchestrator pattern?
        if (userPayee.isEmpty() || userPayer.isEmpty()) {
            throw new IllegalArgumentException("Payer or Payee not found");
        }

        if (userPayer.get().getRole().equals(UserRoleEnum.LOJISTA)) {
            throw new IllegalArgumentException("LOJISTA cannot make payments");
        }

        if (userPayer.get().getWallet().getCurrency().doubleValue() < userPayee.get().getWallet().getCurrency().doubleValue()) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        Transaction transaction = mapper.dtoToDomain(transactionRequestDTO);
        transaction.setPayer(userPayer.get());
        transaction.setPayee(userPayee.get());
        transaction.setStatus("NOTIFIED");
        return transactionRepository.save(transaction);
    }
}
