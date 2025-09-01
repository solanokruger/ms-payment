package com.application.ms_payment.adapters.outbound.entities;

import com.application.ms_payment.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class MongoUserEntity {

    @Id
    private String id;

    @Field("CPF")
    @Indexed(unique=true)
    private Long cpf;

    @Field("CNPJ")
    @Indexed(unique=true)
    private Long cnpj;

    @Field("NAME")
    private String name;

    @Field("EMAIL")
    @Indexed(unique=true)
    private String email;

    @Field("PASSWORD")
    private String password;

    public MongoUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
