package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUserEntity, Long> {

}
