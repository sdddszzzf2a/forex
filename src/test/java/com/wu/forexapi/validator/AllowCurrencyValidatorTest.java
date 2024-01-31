package com.wu.forexapi.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wu.forexapi.exception.CurrencyEnumException;
import com.wu.forexapi.model.dto.ForexQueryDto;

@SpringBootTest
public class AllowCurrencyValidatorTest {

	@Autowired
	private Validator globalValidator;
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenAllowCurrency_NoException() throws Exception {
		
		String currency = "usd";
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				LocalDate.now().minusDays(2),
				LocalDate.now().minusDays(1), 
				currency);
		
		assertThatNoException().isThrownBy(() -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenNotAllowCurrency_ThrowException() throws Exception {
		
		String currency = "ntd";
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				LocalDate.now().minusDays(2),
				LocalDate.now().minusDays(1), 
				currency);
		
		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
}
