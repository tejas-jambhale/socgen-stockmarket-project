package com.project.stockexchangeservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockexchangeservice.model.Company;
import com.project.stockexchangeservice.model.StockExchange;
import com.project.stockexchangeservice.repository.StockExchangeRepository;
import com.project.stockexchangeservice.service.StockExchangeService;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	public List<StockExchange> getExchangeList() {
		return stockExchangeRepository.findAll();
	}
	
	public StockExchange getExchangeFromId(String id) {
		Optional<StockExchange> stockExchange = stockExchangeRepository.findById(id);
		System.out.println(stockExchange);
		return stockExchange.get();
	}

	public List<Company> getCompanyList(String id) {
		StockExchange exc = stockExchangeRepository.findById(id).get();
		return exc.getCompanyList();
	}
	
	public void addStockExchange(StockExchange stockExchange) {
		stockExchangeRepository.save(stockExchange);
	}
	
	public void updateStockExchange(StockExchange stockExchange) {
		stockExchangeRepository.save(stockExchange);
	}
	

}