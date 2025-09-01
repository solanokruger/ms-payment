package com.application.ms_payment.domain.user;

import com.mongodb.lang.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record UserRequestDTO (

    @Nullable
    @Size(max = 11)
    @Pattern(regexp = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})", message = "invalid CPF")
    String cpf,

    @Nullable
    @Size(max = 15)
    @Pattern(regexp = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}-[0-9]{2})|([0-9]{14})", message = "invalid CNPJ")
    String cnpj,

    @NotNull
    String name,

    @NotNull
    String email,

    @NotNull
    String password
){

}
