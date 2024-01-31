package com.wu.forexapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wu.forexapi.annotation.AllowCurrency;
import com.wu.forexapi.enums.Currency;
import com.wu.forexapi.exception.CurrencyEnumException;

public class AllowCurrencyValidator implements ConstraintValidator<AllowCurrency, String>{
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean isConsist = false;
		for (Currency currency : Currency.values()) {
            if (currency.getDisplayName().equals(value)) {
            	isConsist = true;
            	break;
            }
        }
		if(!isConsist) {
			throw new CurrencyEnumException();
		}
        return isConsist;
	}

}
