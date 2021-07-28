package com.project.companyservice.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.model.Company;
import com.project.companyservice.repository.CompanyRepository;
import com.project.companyservice.repository.SectorRepository;
import com.project.companyservice.repository.StockExchangeRepository;
import com.project.companyservice.service.CompanyService;
import com.project.companyservice.model.Sector;
import com.project.companyservice.model.StockExchange;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	SectorRepository sectorRepository;
	
	@Autowired
	StockExchangeRepository stockExchangeRepository;

	public void addCompany(Company company) {
		companyRepository.save(company);
		addCompanyToSector(company.getSector(), company);
		addCompanyToStockExchange(company.getStockExchange(), company);
	}
	
	public void addCompanyToSector(String sectorName, Company company) {
		Sector sector = sectorRepository.findByName(sectorName);
		if (sector != null) {
			if (sector.getCompanies()==null) {
				sector.setCompanies(Arrays.asList(company));
				sector = sectorRepository.save(sector);
			}
			else {
			sector.getCompanies().add(company);
			sector = sectorRepository.save(sector);
			}
		}
	}
	
	public void addCompanyToStockExchange(String exchangeName, Company company) {
		StockExchange stockExchange = stockExchangeRepository.findByName(exchangeName);
		if (stockExchange != null) {
			if (stockExchange.getCompanyList()==null) {
				stockExchange.setCompanyList(Arrays.asList(company));
				stockExchange = stockExchangeRepository.save(stockExchange);
			}
			else {
				stockExchange.getCompanyList().add(company);
				stockExchange = stockExchangeRepository.save(stockExchange);
			}
		}
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
	
	@Override
	public List<Company> getAllCompanies(){
		return companyRepository.findAll();
	}
	
	@Override
	public Company updateCompany(Company company) {
		if(companyRepository.findById(company.getId()) == null)
			return null;
		return companyRepository.save(company);
	}
	
	@Override
	public void deleteCompany(String id) {
		if(companyRepository.findById(id) != null)
			companyRepository.deleteById(id);
	}
}