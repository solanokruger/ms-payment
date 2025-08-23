package com.application.ms_payment.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserRequestDTO (
//    Long id,
    @NotNull
    String cpf,
    @NotNull
    String name,
    @NotNull
    String email,
    @NotNull
    String password
){

}
