package com.jobseeker.technicaltest.validator.constraint;

import com.jobseeker.technicaltest.validator.ApplicantUniqueValidator;
import com.jobseeker.technicaltest.validator.VacancyUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ApplicantUniqueValidator.class)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicantUnique {
    String message() default "Vacancy with the same name already exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}