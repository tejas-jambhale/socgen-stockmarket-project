package com.project.stockpriceservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="stockprice")
public class StockPrice{
	@Id
	public String id;
	@DBRef
	public Company company;
	@DBRef
	public StockExchange stockExchange;
	public String currentPriceDate;
	public double price;
	public String time;
	

	public StockPrice(Company company, StockExchange stockExchange, String currentPriceDate, double price,
			String time) {
		this.company = company;
		this.stockExchange = stockExchange;
		this.currentPriceDate = currentPriceDate;
		this.price = price;
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public StockExchange getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getCurrentPriceDate() {
		return currentPriceDate;
	}
	public void setCurrentPriceDate(String currentPriceDate) {
		this.currentPriceDate = currentPriceDate;
	}
	public String getId() {
		return id;
	}
}