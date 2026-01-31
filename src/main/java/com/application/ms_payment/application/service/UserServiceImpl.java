package com.application.ms_payment.application.service;

import com.application.ms_payment.application.usecases.UserUseCases;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRepository;
import com.application.ms_payment.domain.user.UserRequestDTO;
import com.application.ms_payment.util.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserUseCases {

    private final UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User createUser(UserRequestDTO userRequestDTO) {

        return userRepository.save(userMapper.dtoToEntity(userRequestDTO));
    }
}
