package com.jobseeker.technicaltest.domain.dto.candidate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CandidateDto {
    @NotBlank
    private String email;
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
