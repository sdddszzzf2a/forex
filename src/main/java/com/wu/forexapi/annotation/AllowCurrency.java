package com.wu.forexapi.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.wu.forexapi.validator.AllowCurrencyValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AllowCurrencyValidator.class)
public @interface AllowCurrency {
	
	String message() default "currency must be allow value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
