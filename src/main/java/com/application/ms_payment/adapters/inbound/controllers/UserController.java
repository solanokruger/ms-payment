package com.application.ms_payment.adapters.inbound.controllers;

import com.application.ms_payment.application.service.UserServiceImpl;
import com.application.ms_payment.domain.user.User;
import com.application.ms_payment.domain.user.UserRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User userCreated = this.userService.createUser(userRequestDTO);
        return ResponseEntity.created(null).body(userCreated);
    }

}