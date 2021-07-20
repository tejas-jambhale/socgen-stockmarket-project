package com.project.companyservice.service;

import java.util.List;

import com.project.companyservice.model.StockPrice;

public interface StockPriceService {
	public List<StockPrice> getPrices(String id);

	public void addStockPrice(StockPrice stockPrice);

	public List<StockPrice> getPriceInPeriod(String id, String from, String to);

}