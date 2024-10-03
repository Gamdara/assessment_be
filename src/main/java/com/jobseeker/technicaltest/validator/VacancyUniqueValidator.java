package com.jobseeker.technicaltest.validator;

import com.jobseeker.technicaltest.domain.dto.vacancy.VacancyDto;
import com.jobseeker.technicaltest.repository.VacancyRepository;
import com.jobseeker.technicaltest.validator.constraint.VacancyExist;
import com.jobseeker.technicaltest.validator.constraint.VacancyUnique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VacancyUniqueValidator implements ConstraintValidator<VacancyUnique, VacancyDto> {
    private final VacancyRepository vacancyRepository;


    @Override
    public boolean isValid(VacancyDto value, ConstraintValidatorContext context) {
        return vacancyRepository.findByName(value.getName()).isEmpty();
    }
}
