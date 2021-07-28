package com.project.stockpriceservice.dto;

public class StockPriceDTO{
	String id;
	String companyCode;
	String stockExchangeName;
	double price;
	String currentPriceDate;
	String time;
	public StockPriceDTO(String companyCode, String stockExchangeName, double price, String currentPriceDate, String time) {
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.price = price;
		this.currentPriceDate = currentPriceDate;
		this.time = time;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrentPriceDate() {
		return currentPriceDate;
	}
	public void setCurrentPriceDate(String currentPriceDate) {
		this.currentPriceDate = currentPriceDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
}