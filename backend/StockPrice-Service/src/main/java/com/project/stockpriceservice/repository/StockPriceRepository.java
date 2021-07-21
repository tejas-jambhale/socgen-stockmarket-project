package com.project.stockpriceservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.stockpriceservice.model.StockPrice;


@Repository
public interface StockPriceRepository extends MongoRepository<StockPrice, String>
{
	
}
