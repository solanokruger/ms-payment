package com.application.ms_payment.domain.transaction;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionRequestDTO(
        @NotNull
        BigDecimal value,

        @NotNull
        Long payer,

        @NotNull
        Long payee
) {

}
