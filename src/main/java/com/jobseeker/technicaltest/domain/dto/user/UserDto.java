package com.jobseeker.technicaltest.domain.dto.user;

import com.jobseeker.technicaltest.domain.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Role role;
}
