package com.jobseeker.technicaltest.validator.constraint;

import com.jobseeker.technicaltest.validator.EmailUniqueValidator;
import com.jobseeker.technicaltest.validator.VacancyExistValidator;
import com.jobseeker.technicaltest.validator.VacancyUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = VacancyUniqueValidator.class)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VacancyUnique {
    String message() default "Vacancy with the same name already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}