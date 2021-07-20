package com.project.companyservice.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="ipodetails")
public class IPODetails{
	
	public String id;
	@DBRef
	public Company company;
	@DBRef
	public StockExchange stockExchange;
	public int pricePerShare;
	public int totalShares;
	public String listingDate;
	public String remarks;
	
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
	public int getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(int pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}
	public String getListingDate() {
		return listingDate;
	}
	public void setListingDate(String listingDate) {
		this.listingDate = listingDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getId() {
		return id;
	}
}