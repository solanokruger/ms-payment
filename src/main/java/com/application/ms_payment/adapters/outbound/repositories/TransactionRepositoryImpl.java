package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.JpaTransactionEntity;
import com.application.ms_payment.domain.transaction.Transaction;
import com.application.ms_payment.domain.transaction.TransactionRepository;
import com.application.ms_payment.util.mappers.TransactionMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final JpaTransactionRepository jpaTransactionRepository;
    private final TransactionMapper mapper;

    public TransactionRepositoryImpl(JpaTransactionRepository jpaTransactionRepository, TransactionMapper transactionMapper) {
        this.jpaTransactionRepository = jpaTransactionRepository;
        this.mapper = transactionMapper;
    }

    @Override
    public Transaction save(Transaction transaction) {
        JpaTransactionEntity entity = mapper.toEntity(transaction);

        return mapper.toDomain(jpaTransactionRepository.save(entity));

    }
}
