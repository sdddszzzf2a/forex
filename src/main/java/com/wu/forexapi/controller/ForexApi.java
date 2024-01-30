package com.wu.forexapi.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wu.forexapi.model.Forex;
import com.wu.forexapi.service.ForexService;

@RestController
@RequestMapping("/forex")
public class ForexApi {

//	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private ForexService forexService;
	
	@Value("${openapi.taifex.DailyForeignExchangeRates}")
	private String forexUrl;
	
	@PostMapping("/v1/DailyForeignExchangeRates/save")
	public void saveDailyForeignExchangeRates() throws StreamReadException, DatabindException, IOException {
		ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(forexUrl, byte[].class);
		byte[] responseBody = responseEntity.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		Forex[] forexs = objectMapper.readValue(responseBody, Forex[].class);
		forexService.save(Arrays.asList(forexs));
		System.out.println("api done");
	}
}
