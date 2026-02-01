package com.application.ms_payment.adapters.outbound.repositories;

import com.application.ms_payment.adapters.outbound.entities.JpaUserEntity;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRepository;
import com.application.ms_payment.util.mappers.RoleMapper;
import com.application.ms_payment.util.mappers.UserMapper;
import com.application.ms_payment.util.mappers.WalletMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;
    private final WalletMapper walletMapper;
    private final RoleMapper roleMapper;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository, UserMapper userMapper, WalletMapper walletMapper, RoleMapper roleMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
        this.walletMapper = walletMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public User save(User user) {
        JpaUserEntity jpaUserEntity = userMapper.toEntity(user);


        this.jpaUserRepository.save(jpaUserEntity);

        return new User(
                jpaUserEntity.getId(),
                jpaUserEntity.getDocument(),
                jpaUserEntity.getName(),
                jpaUserEntity.getEmail(),
                jpaUserEntity.getPassword(),
                roleMapper.toDomain(jpaUserEntity.getRole()),
                walletMapper.toDomain(jpaUserEntity.getWallet()));
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<JpaUserEntity> userEntity = this.jpaUserRepository.findById(id);

        return userEntity.map(userMapper::toDomain);
    }
}
