package com.application.ms_payment.domain.user;

import com.application.ms_payment.util.enums.UserRoleEnum;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UserRequestDTO(

        @Nullable
        @Size(max = 15)
        String document,

        @NotNull
        String name,

        @NotNull
        String email,

        @NotNull
        String password,

        @NotNull
        UserRoleEnum role,

        @NotNull
        BigDecimal currency
) {

}
