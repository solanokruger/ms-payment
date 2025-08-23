package com.application.ms_payment.util.mappers;

import com.application.ms_payment.adapters.outbound.entities.MongoUserEntity;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "mongoUserEntity.id", target = "id"),
            @Mapping(source = "mongoUserEntity.cpf", target = "cpf"),
            @Mapping(source = "mongoUserEntity.name", target = "name"),
            @Mapping(source = "mongoUserEntity.email", target = "email"),
            @Mapping(source = "mongoUserEntity.password", target = "password")
    })
    User toDomain(MongoUserEntity mongoUserEntity);

    @Mappings({
            @Mapping(source = "userRequestDTO.cpf", target = "cpf"),
            @Mapping(source = "userRequestDTO.name", target = "name"),
            @Mapping(source = "userRequestDTO.email", target = "email"),
            @Mapping(source = "userRequestDTO.password", target = "password")
    })
    User dtoToEntity(UserRequestDTO userRequestDTO);
}
