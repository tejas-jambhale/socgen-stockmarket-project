package com.project.stockexchangeservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stockexchange")
public class StockExchange{
	@Id
	String id;
	String name;
	String brief;
	String address;
	String remarks;
	@DBRef
	List<Company> companyList;

	public StockExchange() {
	}

	public StockExchange(String id, String name, String brief, String address, String remarks, List<Company> companyList) {
		this.id = id;
		this.name = name;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
		this.companyList = companyList;
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

	public String getId() {
		return id;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	
	
}