package com.application.ms_payment.adapters.outbound.entities;

import com.application.ms_payment.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class MongoUserEntity {

    @Id
    private String id;
    @UniqueElements
    private String cpf;
    private String name;
    private String email;
    private String password;

    public MongoUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
