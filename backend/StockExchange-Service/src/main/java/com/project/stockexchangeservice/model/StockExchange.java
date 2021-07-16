package com.project.stockexchangeservice.model;

import org.springframework.data.annotation.Id;

public class StockExchange{
	@Id
	int id;
	String name;
	String brief;
	String address;
	String remarks;

	public StockExchange() {
	}

	public StockExchange(int id, String name, String brief, String address, String remarks) {
		this.id = id;
		this.name = name;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}
}