package com.jobseeker.technicaltest.domain.dto.applicant;

import com.jobseeker.technicaltest.domain.enums.ApplyStatus;
import com.jobseeker.technicaltest.validator.constraint.VacancyExist;
import lombok.Data;

@Data
public class ApplicantDto {
    @VacancyExist
    private String vacancyId;
    private String candidateId;
    private ApplyStatus applyStatus = ApplyStatus.applied;
}
