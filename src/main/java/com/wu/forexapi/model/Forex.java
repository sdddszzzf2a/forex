package com.wu.forexapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forex {

	@Id
	@JsonProperty("Date")
	private String date;
	
	@JsonProperty("USD/NTD")
	private String usdToNtd;

	public Forex() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		LocalDate localDate  = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDateTime localDateTime = localDate.atStartOfDay();
		this.date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public String getUsdToNtd() {
		return usdToNtd;
	}

	public void setUsdToNtd(String usdToNtd) {
		this.usdToNtd = usdToNtd;
	}

	@Override
	public String toString() {
		return "Forex [date=" + date + ", usdToNtd=" + usdToNtd + "]";
	}
}
