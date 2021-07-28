package com.project.companyservice.dto;

public class IPODto{
	String id;
	String companyName;
	String stockExchangeName;
	int pricePerShare;
	int totalShares;
	String listingDate;
	String remarks;
	
	public IPODto(String companyName, String stockExchangeName, int pricePerShare, int totalShares, String listingDate,
			String remarks) {
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
		this.pricePerShare = pricePerShare;
		this.totalShares = totalShares;
		this.listingDate = listingDate;
		this.remarks = remarks;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
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
	public void setListDate(String listingDate) {
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