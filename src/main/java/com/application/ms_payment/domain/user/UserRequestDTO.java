package com.application.ms_payment.domain.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @Nullable
        @Size(max = 15)
        String document,

        @NotNull
        String name,

        @NotNull
        String email,

        @NotNull
        String password
) {

}
