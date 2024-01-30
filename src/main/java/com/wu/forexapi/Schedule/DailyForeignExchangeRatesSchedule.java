package com.wu.forexapi.Schedule;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.wu.forexapi.controller.ForexApi;

@Component
public class DailyForeignExchangeRatesSchedule {

	@Autowired
	private ForexApi forexApi;
	
	@Scheduled(cron = "0 0 18 * * ?")
	public void saveDailyForeignExchangeRates() throws StreamReadException, DatabindException, IOException {
		forexApi.saveDailyForeignExchangeRates();
	}
}
