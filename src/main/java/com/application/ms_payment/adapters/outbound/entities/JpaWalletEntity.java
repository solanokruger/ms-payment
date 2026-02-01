package com.application.ms_payment.adapters.outbound.entities;

import com.application.ms_payment.domain.user.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "WALLET")
public class JpaWalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CURRENCY")
    private BigDecimal currency;

    public JpaWalletEntity(Wallet wallet) {
        this.id = wallet.getId();
        this.currency = wallet.getCurrency();
    }

}
