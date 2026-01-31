package com.application.ms_payment.application.usecases;

import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRequestDTO;

public interface UserUseCases {

    public User createUser(UserRequestDTO userRequestDTO);

}
