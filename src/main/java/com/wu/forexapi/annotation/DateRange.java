package com.wu.forexapi.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.wu.forexapi.validator.DateRangeValidator;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {

	String startDate();

    String endDate();

    String message() default "日期區間不符";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
