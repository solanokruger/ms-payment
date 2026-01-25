package com.application.ms_payment.application.service;

import com.application.ms_payment.application.usecases.UserUseCases;
import com.application.ms_payment.domain.role.RoleRepository;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRepository;
import com.application.ms_payment.domain.user.UserRequestDTO;
import com.application.ms_payment.util.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserUseCases {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public User createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.dtoToEntity(userRequestDTO);

        user.setRole(roleRepository.findByRole(userRequestDTO.role()));

        return userRepository.save(user);
    }
}
