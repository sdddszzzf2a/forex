package com.wu.forexapi.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wu.forexapi.annotation.WithinOneYear;
import com.wu.forexapi.exception.DateRangeException;

public class WithinOneYearValidator implements ConstraintValidator<WithinOneYear, LocalDate>{

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        LocalDate now = LocalDate.now();
        LocalDate oneYearAgo = now.minusYears(1).minusDays(1);
        if(!(value.isAfter(oneYearAgo) && value.isBefore(now))) {
        	throw new DateRangeException();
        }
        return true;
	}

}
