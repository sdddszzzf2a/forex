package com.wu.forexapi.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wu.forexapi.annotation.DateRange;
import com.wu.forexapi.exception.DateRangeException;
import com.wu.forexapi.model.dto.ForexQueryDto;

public class DateRangeValidator implements ConstraintValidator<DateRange, ForexQueryDto>{

	@Override
	public boolean isValid(ForexQueryDto value, ConstraintValidatorContext context) {
		LocalDate startDate = value.getStartDate();
        LocalDate endDate = value.getEndDate();
        if(!(endDate.isAfter(startDate))) {
        	throw new DateRangeException();
        }
		return true;
	}

}
