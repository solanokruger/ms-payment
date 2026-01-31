package com.application.ms_payment.util.mappers;

import com.application.ms_payment.adapters.outbound.entities.JpaUserEntity;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "jpaUserEntity.id", target = "id"),
            @Mapping(source = "jpaUserEntity.document", target = "document"),
            @Mapping(source = "jpaUserEntity.name", target = "name"),
            @Mapping(source = "jpaUserEntity.email", target = "email"),
            @Mapping(source = "jpaUserEntity.password", target = "password")
    })
    User toDomain(JpaUserEntity jpaUserEntity);

    @Mappings({
            @Mapping(source = "userRequestDTO.document", target = "document"),
            @Mapping(source = "userRequestDTO.name", target = "name"),
            @Mapping(source = "userRequestDTO.email", target = "email"),
            @Mapping(source = "userRequestDTO.password", target = "password"),
            @Mapping(source = "userRequestDTO.role", target = "role"),
            @Mapping(source = "userRequestDTO.currency", target = "wallet.currency")
    })
    User dtoToDomain(UserRequestDTO userRequestDTO);

    JpaUserEntity toEntity(User user);

//    UserRole map(String role);
//
//    UserRole map(JpaUserRoleEntity jpaUserRoleEntity);
//
//    Wallet map(JpaUserWalletEntity jpaUserWalletEntity);
}
