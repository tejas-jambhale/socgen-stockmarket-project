package com.project.companyservice.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.companyservice.model.Company;
import com.project.companyservice.model.StockPrice;

@Repository
public interface StockPriceRepository extends MongoRepository<StockPrice, String>{
	public Optional<StockPrice> findById(ObjectId objectId);
	public Optional<StockPrice> findByCompany(Company company);
	public List<StockPrice> findAll();
}