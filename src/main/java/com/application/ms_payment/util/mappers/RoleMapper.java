package com.application.ms_payment.util.mappers;

import com.application.ms_payment.adapters.outbound.entities.JpaRoleEntity;
import com.application.ms_payment.domain.role.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    List<Role> toDomain(List<JpaRoleEntity> entities);

    Role toDomain(JpaRoleEntity entity);

    JpaRoleEntity toEntity(Role role);
}
