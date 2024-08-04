package com.webmvcHomework.__home_work.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {passwordValidator.class})

public @interface passwordAnotation  {
    String message() default "password must contain a uppercase , lowercase ,and special character";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
