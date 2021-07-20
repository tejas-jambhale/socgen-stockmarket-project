package com.project.companyservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.model.Company;
import com.project.companyservice.repository.CompanyRepository;
import com.project.companyservice.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public void addCompany(Company company) {
		companyRepository.save(company);
	}
	
	@Override
	public List<Company> getMatchingCompanies(String pattern) 
	{
		List<Company> companies = companyRepository.findByNameIgnoreCaseContaining(pattern);
		return companies;
	}
	
	@Override
	public Company getCompanyDetails(String id) {
		return companyRepository.findById(id).get();
	}
}