package com.project.companyservice.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.model.StockPrice;
import com.project.companyservice.repository.CompanyRepository;
import com.project.companyservice.repository.StockPriceRepository;
import com.project.companyservice.service.StockPriceService;

@Service
public class StockPriceImpl implements StockPriceService {

	@Autowired
	StockPriceRepository stockPriceRepository;

	@Autowired
	CompanyRepository companyRepository;

	public List<StockPrice> getPrices(String id) {
		List<StockPrice> priceList = stockPriceRepository.findAll();
		List<StockPrice> finalPrice = new ArrayList<>();
		for (StockPrice sp : priceList) {
			if (sp.getCompany().getId().equals(id)) {
				finalPrice.add(sp);
			}
		}
		return finalPrice;
	}

	public void addStockPrice(StockPrice stockPrice) {
		stockPriceRepository.save(stockPrice);
	}

	public List<StockPrice> getPriceInPeriod(String id, String from, String to) {
		List<StockPrice> priceList = stockPriceRepository.findAll();
		List<StockPrice> finalPrice = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate start = LocalDate.parse(from, formatter);
		LocalDate end = LocalDate.parse(to, formatter);
		for (StockPrice sp : priceList) {
			if (sp.getCompany().getId().equals(id)) {
				LocalDate current = LocalDate.parse(sp.getCurrentPriceDate(), formatter);
				if(current.compareTo(start)>0 && current.compareTo(end)<0)
					finalPrice.add(sp);
			}
		}
		return finalPrice;
	}
}