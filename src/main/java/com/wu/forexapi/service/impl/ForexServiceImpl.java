package com.wu.forexapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.forexapi.model.Forex;
import com.wu.forexapi.repository.ForexRepository;
import com.wu.forexapi.service.ForexService;

@Service
public class ForexServiceImpl implements ForexService{

	@Autowired
	private ForexRepository forexRepository;

	public void save(List<Forex> forex) {
		forexRepository.saveAll(forex);
	}
}
