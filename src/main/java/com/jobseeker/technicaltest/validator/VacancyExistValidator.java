package com.jobseeker.technicaltest.validator;

import com.jobseeker.technicaltest.repository.VacancyRepository;
import com.jobseeker.technicaltest.validator.constraint.VacancyExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VacancyExistValidator implements ConstraintValidator<VacancyExist, String> {
    private final VacancyRepository vacancyRepository;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return vacancyRepository.findById(value).isPresent();
    }
}
