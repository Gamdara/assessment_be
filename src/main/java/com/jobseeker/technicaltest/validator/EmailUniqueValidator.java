package com.jobseeker.technicaltest.validator;

import com.jobseeker.technicaltest.domain.dto.vacancy.VacancyDto;
import com.jobseeker.technicaltest.repository.UserRepository;
import com.jobseeker.technicaltest.repository.VacancyRepository;
import com.jobseeker.technicaltest.validator.constraint.EmailUnique;
import com.jobseeker.technicaltest.validator.constraint.VacancyUnique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
    private final UserRepository userRepository;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findByEmail(value).isEmpty();
    }
}
