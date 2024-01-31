package com.wu.forexapi.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wu.forexapi.model.dto.ForexQueryDto;

@SpringBootTest
public class WithinOneYearValidatorTest {

	@Autowired
	private Validator globalValidator;
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateWithinOneYear_NoException() {
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today.minusDays(1), currency);
		
		assertThatNoException().isThrownBy(() -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateEqualsOneYear_NoException() {
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusYears(1), today.minusDays(1), currency);
		
		assertThatNoException().isThrownBy(() -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateBeforeOneYear_ThrowException() {
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusYears(1).minusDays(1), today.minusDays(1), currency);
		
		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
}
