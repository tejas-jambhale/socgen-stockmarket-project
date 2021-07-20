package com.project.stockexchangeservice.service;

import java.util.List;

import com.project.stockexchangeservice.model.Company;
import com.project.stockexchangeservice.model.StockExchange;



public interface StockExchangeService 
{
	public List<StockExchange> getExchangeList();

	public void addStockExchange(StockExchange stockExchange);

	public List<Company> getCompanyList(String id);

	public StockExchange getExchangeFromId(String id);

	public void updateStockExchange(StockExchange stockExchange);

	public void addCompanyToExchange(String exchangename, Company company);
}
