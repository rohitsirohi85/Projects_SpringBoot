package com.webmvcHomework.__home_work.customAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class passwordValidator implements ConstraintValidator<passwordAnotation , String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;

        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }

            // If all conditions are met, we can return true immediately
            if (hasUpper && hasLower && hasSpecial) {
                return true;
            }
        }

        return hasUpper && hasLower && hasSpecial;
    }
    }
    

