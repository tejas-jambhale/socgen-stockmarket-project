package com.project.companyservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.companyservice.model.StockExchange;

@Repository
public interface StockExchangeRepository extends MongoRepository<StockExchange, String>{
	public StockExchange findByName(String name);
}