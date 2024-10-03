package com.jobseeker.technicaltest.validator;

import com.jobseeker.technicaltest.domain.dto.applicant.ApplicantDto;
import com.jobseeker.technicaltest.repository.ApplicantRepository;
import com.jobseeker.technicaltest.repository.VacancyRepository;
import com.jobseeker.technicaltest.validator.constraint.ApplicantUnique;
import com.jobseeker.technicaltest.validator.constraint.VacancyUnique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApplicantUniqueValidator implements ConstraintValidator<ApplicantUnique, ApplicantDto> {
    private final ApplicantRepository applicantRepository;


    @Override
    public boolean isValid(ApplicantDto value, ConstraintValidatorContext context) {
        return applicantRepository.findByVacancyIdAndCandidateId(value.getVacancyId(), value.getCandidateId()).isPresent();
    }


}
