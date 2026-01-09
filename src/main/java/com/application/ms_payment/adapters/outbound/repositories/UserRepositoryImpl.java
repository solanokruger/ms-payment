package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.JpaUserEntity;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRepository;
import com.application.ms_payment.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Autowired
    private UserMapper userMapper;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        JpaUserEntity jpaUserEntity = new JpaUserEntity(user);
        this.jpaUserRepository.save(jpaUserEntity);

        return new User(
                jpaUserEntity.getId(), jpaUserEntity.getDocument(), jpaUserEntity.getName(), jpaUserEntity.getEmail(), jpaUserEntity.getPassword());
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<JpaUserEntity> userEntity = this.jpaUserRepository.findById(id);

        return userEntity.map(userMapper::toDomain);
    }
}
