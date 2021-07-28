package com.project.stockexchangeservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.stockexchangeservice.model.StockExchange;

@Repository
public interface StockExchangeRepository extends MongoRepository<StockExchange, String>{
	public List<StockExchange> findAll();
	public Optional<StockExchange> findById(String id);
	public StockExchange findByName(String name);	
	public void deleteById(String id);
}