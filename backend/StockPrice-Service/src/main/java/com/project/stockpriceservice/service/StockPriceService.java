package com.project.stockpriceservice.service;

import java.util.List;

import com.project.stockpriceservice.model.StockPrice;

public interface StockPriceService 
{
	public List<StockPrice> findAll();
	public StockPrice findById(String id);
	public void deleteById(String id);
	public List<StockPrice> save(List<StockPrice> stockPrice);
	public StockPrice update(StockPrice stockPrice);
	public List<StockPrice> getSectorStockPrices(String sectorname, String exchange, String from, String to);
}
