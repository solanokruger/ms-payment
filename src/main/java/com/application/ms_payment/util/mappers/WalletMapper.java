package com.application.ms_payment.util.mappers;

import com.application.ms_payment.adapters.outbound.entities.JpaWalletEntity;
import com.application.ms_payment.domain.user.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    @Mappings({
            @Mapping(source = "jpaWalletEntity.id", target = "id"),
            @Mapping(source = "jpaWalletEntity.currency", target = "currency"),

    })
    Wallet toDomain(JpaWalletEntity jpaWalletEntity);

}
