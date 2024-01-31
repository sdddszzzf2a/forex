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
public class DateRangeValidatorTest {
	
	@Autowired
	private Validator globalValidator;

	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateBeforeEndDate_NoException() {
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today.minusDays(1), currency);
		
		assertThatNoException().isThrownBy(() -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateEqualseEndDate_NoException() {
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today.minusDays(2), currency);

		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateAfterEndDate_NoException() {
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(1), today.minusDays(2), currency);

		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
}
