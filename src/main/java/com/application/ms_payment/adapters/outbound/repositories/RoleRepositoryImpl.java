package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.JpaRoleEntity;
import com.application.ms_payment.domain.role.Role;
import com.application.ms_payment.domain.role.RoleRepository;
import com.application.ms_payment.util.enums.UserRoleEnum;
import com.application.ms_payment.util.mappers.RoleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    private final JpaRoleRepository jpaRoleRepository;
    private final RoleMapper roleMapper;

    public RoleRepositoryImpl(JpaRoleRepository jpaRoleRepository, RoleMapper roleMapper) {
        this.jpaRoleRepository = jpaRoleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public Role save(Role role) {
        JpaRoleEntity roleEntity = roleMapper.toEntity(role);

        this.jpaRoleRepository.save(roleEntity);

        return new Role(
                roleEntity.getId(),
                roleEntity.getRole()
        );
    }

    @Override
    public Role findByRole(UserRoleEnum roleEnum) {
        JpaRoleEntity roleEntity = this.jpaRoleRepository.findByRole(roleEnum);

        return roleMapper.toDomain(roleEntity);
    }
}
