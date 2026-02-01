package com.application.ms_payment.domain.role;

import com.application.ms_payment.util.enums.UserRoleEnum;

public class Role {
    private Long id;
    private UserRoleEnum role;

    public Role() {
    }

    public Role(Long id, UserRoleEnum role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
