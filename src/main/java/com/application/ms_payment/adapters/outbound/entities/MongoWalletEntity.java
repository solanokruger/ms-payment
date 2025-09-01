package com.application.ms_payment.adapters.outbound.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "wallet")
public class MongoWalletEntity {

    @Id
    private String id;

    @Field("currency")
    private BigDecimal currency;

}
