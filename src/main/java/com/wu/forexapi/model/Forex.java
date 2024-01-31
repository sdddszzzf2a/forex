package com.wu.forexapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forex {

	@Id
	@JsonIgnore
	private String id;
	
	@JsonAlias("Date")
	@JsonProperty("date")
	@JsonFormat(pattern="yyyyMMdd")
	private LocalDate date;
	
	@JsonAlias("USD/NTD")
	@JsonProperty("usd")
	private String usdToNtd;

	public Forex() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.id = date.atStartOfDay().format(formatter);
		this.date = date;
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
