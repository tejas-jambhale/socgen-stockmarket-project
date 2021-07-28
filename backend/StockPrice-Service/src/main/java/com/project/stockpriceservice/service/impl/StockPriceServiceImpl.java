package com.project.stockpriceservice.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockpriceservice.dto.StockPriceDTO;
import com.project.stockpriceservice.model.Company;
import com.project.stockpriceservice.model.Sector;
import com.project.stockpriceservice.model.StockExchange;
import com.project.stockpriceservice.model.StockPrice;
import com.project.stockpriceservice.repository.CompanyRepository;
import com.project.stockpriceservice.repository.SectorRepository;
import com.project.stockpriceservice.repository.StockExchangeRepository;
import com.project.stockpriceservice.repository.StockPriceRepository;
import com.project.stockpriceservice.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	@Autowired
	private StockPriceRepository stockPriceRepository;
	
	@Autowired
	private SectorRepository sectorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	public List<StockPrice> findAll() {
		List<StockPrice> stockPrices = stockPriceRepository.findAll();
		return stockPrices;
	}

	public StockPrice findById(String id) {
		Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
		if (!stockPrice.isPresent())
			return null;
		return stockPrice.get();
	}

	public List<StockPrice> save(List<StockPrice> stockPrice) {
		stockPrice = stockPriceRepository.saveAll(stockPrice);
		return stockPrice;
	}

	public StockPrice update(StockPrice stockPrice) {
		if (findById(stockPrice.getId()) == null)
			return null;
		return stockPriceRepository.save(stockPrice);
	}

	public void deleteById(String id) {
		stockPriceRepository.deleteById(id);
	}
	
	public List<StockPrice> getSectorStockPrices(String sectorname, String exchange, String from, String to){
		Sector sector = sectorRepository.findByName(sectorname);
		
		List<StockPrice> priceList = stockPriceRepository.findAll();
		List<StockPrice> finalPrice = new ArrayList<>();
		List<Company> companyList = sector.getCompanies();
		List<String> companyNames = new ArrayList<>();
		for (Company com: companyList) {
			companyNames.add(com.getName());
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate start = LocalDate.parse(from, formatter);
		LocalDate end = LocalDate.parse(to, formatter);
		for (StockPrice sp : priceList) {
			if (companyNames.contains(sp.getCompany().getName()) && sp.getStockExchange().getName().equals(exchange)) {
				LocalDate current = LocalDate.parse(sp.getCurrentPriceDate(), formatter);
				if(current.compareTo(start)>0 && current.compareTo(end)<0)
					finalPrice.add(sp);
			}
		}
		return finalPrice;
	}
	
	public List<StockPrice> getCompanyStockPrices(String companyname, String exchange, String from, String to){
		List<StockPrice> priceList = stockPriceRepository.findAll();
		List<StockPrice> finalPrice = new ArrayList<>();
		System.out.println(priceList);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate start = LocalDate.parse(from, formatter);
		LocalDate end = LocalDate.parse(to, formatter);
		for (StockPrice sp : priceList) {
			System.out.println(companyname + sp.getCompany().getName() + exchange + sp.getStockExchange().getName() );
			if (companyname.equals(sp.getCompany().getName()) && sp.getStockExchange().getName().equals(exchange)) {
				System.out.println("In IF");
				LocalDate current = LocalDate.parse(sp.getCurrentPriceDate(), formatter);
				System.out.println(current.toString());
				if(current.compareTo(start)>0 && current.compareTo(end)<0) {
					System.out.println(sp.getCompany().getName());
					finalPrice.add(sp);
				}
			}
			System.out.println("Iteration");
		}
		return finalPrice;
	}
	
	public void saveList(List<StockPriceDTO> stockPriceDTO){
		List<StockPrice> stockPriceList = new ArrayList<>();
		for (StockPriceDTO sp:stockPriceDTO) {
			Company company = companyRepository.findByCode(sp.getCompanyCode());
			StockExchange stockExchange = stockExchangeRepository.findByName(sp.getStockExchangeName());
			StockPrice stockPrice = new StockPrice(company, stockExchange, sp.getCurrentPriceDate(), sp.getPrice(), sp.getTime());
			stockPriceList.add(stockPrice);
		}
		stockPriceRepository.saveAll(stockPriceList);
	}

}
