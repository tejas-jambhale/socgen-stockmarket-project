package com.project.companyservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.dto.IPODto;
import com.project.companyservice.model.Company;
import com.project.companyservice.model.IPODetails;
import com.project.companyservice.model.StockExchange;
import com.project.companyservice.repository.CompanyRepository;
import com.project.companyservice.repository.IpoRepository;
import com.project.companyservice.repository.StockExchangeRepository;
import com.project.companyservice.service.IpoService;

@Service
public class IpoServiceImpl implements IpoService
{
	@Autowired
	private IpoRepository ipoRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private StockExchangeRepository stockExchangeRepository;
	
	@Override
	public List<IPODetails> findAll() {
		List<IPODetails> ipos = ipoRepository.findAll();
		return ipos;
	}
	
	@Override
	public IPODetails findById(String id) {
		Optional<IPODetails> ipo = ipoRepository.findById(id);
		if(!ipo.isPresent())
			return null;
		return ipo.get();
	}
	
	@Override
	public IPODetails save(IPODetails ipo) {
		ipo = ipoRepository.save(ipo);
		return ipo;
	}
	
	@Override
	public IPODetails update(IPODetails ipo) {
		if(ipoRepository.findById(ipo.getId()) == null)
			return null;
		IPODetails finalIpo = ipoRepository.save(ipo);
		return finalIpo;
	}
	
	@Override
	public void deleteById(String id) {
		if(ipoRepository.findById(id) != null)
			ipoRepository.deleteById(id);
	}
	
	@Override
	public void addNewIpo(IPODto ipo) {
		IPODetails newIpo = new IPODetails();
		Company company = companyRepository.findByName(ipo.getCompanyName());
		StockExchange stockExchange = stockExchangeRepository.findByName(ipo.getStockExchangeName());
		newIpo.setCompany(company);
		newIpo.setStockExchange(stockExchange);
		newIpo.setListingDate(ipo.getListingDate());
		newIpo.setPricePerShare(ipo.getPricePerShare());
		newIpo.setTotalShares(ipo.getTotalShares());
		newIpo.setRemarks(ipo.getRemarks());
		ipoRepository.save(newIpo);
	}
}
