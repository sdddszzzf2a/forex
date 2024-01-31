package com.wu.forexapi.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wu.forexapi.annotation.AllowCurrency;
import com.wu.forexapi.annotation.BeforeToday;
import com.wu.forexapi.annotation.DateRange;
import com.wu.forexapi.annotation.WithinOneYear;

@DateRange(startDate = "startDate", endDate = "endDate")
public class ForexQueryDto {

	@JsonFormat(pattern="yyyy/MM/dd")
	@WithinOneYear
	private LocalDate startDate;
	
	@JsonFormat(pattern="yyyy/MM/dd")
	@BeforeToday
	private LocalDate endDate;
	
	@AllowCurrency
	private String currency;

	public ForexQueryDto() {
		super();
	}

	public ForexQueryDto(LocalDate startDate, LocalDate endDate, String currency) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.currency = currency;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "ForexQueryDto [startDate=" + startDate + ", endDate=" + endDate + ", currency=" + currency + "]";
	}
}
