package com.project.companyservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.companyservice.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{
	public Optional<Company> findById(String id);
	public Company findByName(String name);
	public List<Company> findByNameIgnoreCaseContaining(String pattern);
	public List<Company> findAll();
	public void deleteById(String id);
}