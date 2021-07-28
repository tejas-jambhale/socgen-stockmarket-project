package com.project.companyservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.companyservice.model.Company;

@Service
public interface CompanyService 
{
	
	public void addCompany(Company company);

	public List<Company> getMatchingCompanies(String pattern);

	public Company getCompanyDetails(String id);

	public List<Company> getAllCompanies();

	public Company updateCompany(Company company);

	public void deleteCompany(String id);
}
