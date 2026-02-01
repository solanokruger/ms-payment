package com.application.ms_payment.util.mappers;

import com.application.ms_payment.adapters.outbound.entities.JpaTransactionEntity;
import com.application.ms_payment.domain.transaction.Transaction;
import com.application.ms_payment.domain.transaction.TransactionRequestDTO;
import com.application.ms_payment.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.math.BigDecimal;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "transaction.id", target = "id"),
            @Mapping(source = "transaction.value", target = "amount"),
            @Mapping(source = "transaction.payer", target = "userPayer"),
            @Mapping(source = "transaction.payee", target = "userPayee"),
            @Mapping(source = "transaction.transactionDate", target = "transactionDate"),
            @Mapping(source = "transaction.status", target = "status")
    })
    JpaTransactionEntity toEntity(Transaction transaction);

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.amount", target = "value"),
            @Mapping(source = "entity.userPayer", target = "payer"),
            @Mapping(source = "entity.userPayee", target = "payee"),
            @Mapping(source = "entity.transactionDate", target = "transactionDate"),
            @Mapping(source = "entity.status", target = "status")
    })
    Transaction toDomain(JpaTransactionEntity entity);

    @Mappings({
            @Mapping(source = "transactionRequestDTO.value", target = "value"),
            @Mapping(source = "transactionRequestDTO.payer", target = "payer.id"),
            @Mapping(source = "transactionRequestDTO.payee", target = "payee.id"),
    })
    Transaction dtoToDomain(TransactionRequestDTO transactionRequestDTO);

}
