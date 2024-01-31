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
public class BeforeTodayValidatorTest {

	@Autowired
	private Validator globalValidator;
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateBeforeToday_NoException() {
		
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today.minusDays(1), currency);
		
		assertThatNoException().isThrownBy(() -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateEqualsToday_ThrowNoException() {
		
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today, today.minusDays(1), currency);

		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenStartDateAfterToday_ThrowNoException() {
		
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.plusDays(1), today.minusDays(1), currency);

		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenEndDateBeforeToday_NoException() {
		
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today.minusDays(1), currency);
		
		assertThatNoException().isThrownBy(() -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenEndDateEqualsToday_ThrowNoException() {
		
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today, currency);

		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
	
	@Test
	public void testGetDailyForeignExchangeRatesByDate_WhenEndDateAfterToday_ThrowNoException() {
		
		String currency = "usd";
		LocalDate today = LocalDate.now();
		ForexQueryDto forexQueryDto = new ForexQueryDto(
				today.minusDays(2), today.plusDays(1), currency);

		assertThrows(RuntimeException.class, () -> {
			globalValidator.validate(forexQueryDto);
        });
	}
}
