package com.project.stockpriceservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.stockpriceservice.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{
	public Company findByCode(String code);

	public Company findByName(String companyname); 
}