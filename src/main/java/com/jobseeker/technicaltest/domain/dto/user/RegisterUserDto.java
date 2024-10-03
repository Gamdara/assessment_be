package com.jobseeker.technicaltest.domain.dto.user;

import com.jobseeker.technicaltest.domain.enums.Role;
import com.jobseeker.technicaltest.validator.constraint.EmailUnique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Date;

@Data
public class RegisterUserDto {
    @NotBlank
    @EmailUnique
    private String email;
    @NotBlank
    private String password;
    private Role role = Role.ROLE_CANDIDATE;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String fullName;
    @Past
    private Date dateOfBirth;
    @NotBlank
    private String placeOfBirth;
    @NotBlank
    private String gender;
    @PositiveOrZero
    private int yearsOfExperience;
    @PositiveOrZero
    private Long lastSalary;
}
