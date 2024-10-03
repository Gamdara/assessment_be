package com.jobseeker.technicaltest.validator.constraint;

import com.jobseeker.technicaltest.validator.VacancyExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = VacancyExistValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VacancyExist {
    String message() default "Vacancy does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}