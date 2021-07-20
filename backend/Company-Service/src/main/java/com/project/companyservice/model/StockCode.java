package com.project.companyservice.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="stockcode")
public class StockCode{
	public String id;
	@DBRef
	public StockExchange stockExchange;
	@DBRef
	public Company company;
}