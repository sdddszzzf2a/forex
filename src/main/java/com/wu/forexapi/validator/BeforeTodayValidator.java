package com.wu.forexapi.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wu.forexapi.annotation.BeforeToday;
import com.wu.forexapi.exception.DateRangeException;

public class BeforeTodayValidator implements ConstraintValidator<BeforeToday, LocalDate>{

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		LocalDate now = LocalDate.now();
		if(!(value.isBefore(now))) {
			throw new DateRangeException();
		}
        return true;
	}

}
