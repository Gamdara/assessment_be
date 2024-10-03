package com.jobseeker.technicaltest.domain.dto.vacancy;

import com.jobseeker.technicaltest.domain.enums.Role;
import com.jobseeker.technicaltest.domain.enums.VacancyStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class VacancyDto {
    @NotBlank
    private String name;
    @Positive
    private int maxAge;
    @Positive
    private Long salary;
    @NotBlank
    private String description;
    @Future
    private Date expiredDate;

    private VacancyStatus status = VacancyStatus.open;
}
