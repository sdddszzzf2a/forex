package com.wu.forexapi.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wu.forexapi.model.ErrorStatus;
import com.wu.forexapi.model.Forex;
import com.wu.forexapi.model.ResponseObject;
import com.wu.forexapi.model.dto.ForexQueryDto;
import com.wu.forexapi.service.ForexService;


@RestController
@RequestMapping("/forex")
public class ForexApi {

	private static final Logger logger = LoggerFactory.getLogger(ForexApi.class);
	
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
		logger.info("save daily foreign exchange rates success!");
	}
	
	@PostMapping("/v1/DailyForeignExchangeRates")
	public ResponseObject getDailyForeignExchangeRatesByDate(
			@Valid @RequestBody ForexQueryDto forexQueryDto) throws Exception {
		
		ResponseObject response = null;
		ErrorStatus errorStatus = null;
		String stratDate = dateTimeFormat(forexQueryDto.getStartDate());
		String endDate = dateTimeFormat(forexQueryDto.getEndDate());
		Forex[] forexs = forexService.findByDate(stratDate, endDate);
		errorStatus = new ErrorStatus("0000", "成功");
		response = new ResponseObject(errorStatus, forexs);
		return response;
	}
	
	private String dateTimeFormat(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return date.atStartOfDay().format(formatter);
	}
}
