package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.MongoUserEntity;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRepository;
import com.application.ms_payment.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final MongoUserRepository mongoUserRepository;

    @Autowired
    private UserMapper userMapper;

    public UserRepositoryImpl(MongoUserRepository mongoUserRepository, UserMapper userMapper) {
        this.mongoUserRepository = mongoUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        MongoUserEntity mongoUserEntity = new MongoUserEntity(user);
        this.mongoUserRepository.save(mongoUserEntity);

        return new User(mongoUserEntity.getId(), mongoUserEntity.getCpf(), mongoUserEntity.getName(), mongoUserEntity.getEmail(), mongoUserEntity.getPassword());
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<MongoUserEntity> userEntity = this.mongoUserRepository.findById(id);

        return userEntity.map(userMapper::toDomain);
    }
}
