package com.project.companyservice.service;

import java.util.List;

import com.project.companyservice.model.Company;


public interface CompanyService 
{
	
	public void addCompany(Company company);

	public List<Company> getMatchingCompanies(String pattern);

	public Company getCompanyDetails(String id);
}
