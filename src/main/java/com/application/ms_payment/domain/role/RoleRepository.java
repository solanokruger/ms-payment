package com.application.ms_payment.domain.role;

import com.application.ms_payment.util.enums.UserRoleEnum;

public interface RoleRepository {

    Role save(Role role);

    Role findByRole(UserRoleEnum roleEnum);

}
