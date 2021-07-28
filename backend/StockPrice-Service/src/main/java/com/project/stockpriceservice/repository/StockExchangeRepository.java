package com.project.stockpriceservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.stockpriceservice.model.StockExchange;

@Repository
public interface StockExchangeRepository extends MongoRepository<StockExchange, String> {
	public StockExchange findByName(String name); 
}