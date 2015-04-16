package com.github.jlgrock.autograder.domain

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

/**
 *
 */
class CourseValidator implements ConstraintValidator<Course, String> {
    @Override
    void initialize(Course constraintAnnotation) {

    }

    @Override
    boolean isValid(String value, ConstraintValidatorContext context) {
        return false
    }
}
