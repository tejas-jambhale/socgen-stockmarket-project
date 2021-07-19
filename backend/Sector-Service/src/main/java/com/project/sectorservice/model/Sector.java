package com.project.sectorservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sector")
public class Sector{
	@Id
	String id;
	String name;
	String brief;
	String[] companies;
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
	public String getId() {
		return id;
	}
	public String[] getCompanies() {
		return companies;
	}
	public void setCompanies(String[] companies) {
		this.companies = companies;
	}
	
	
}