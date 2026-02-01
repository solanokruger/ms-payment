package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.JpaRoleEntity;
import com.application.ms_payment.util.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository extends JpaRepository<JpaRoleEntity, Long> {

    JpaRoleEntity findByRole(UserRoleEnum role);
}
