package com.project.companyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.companyservice.model.Company;
import com.project.companyservice.model.IPODetails;
import com.project.companyservice.model.StockPrice;
import com.project.companyservice.service.CompanyService;
import com.project.companyservice.service.IpoService;
import com.project.companyservice.service.StockPriceService;

@RestController
class CompanyServiceController {

	@Autowired
	CompanyService companyService;

	@Autowired
	StockPriceService stockPriceService;

	@Autowired
	private IpoService ipoService;

	@RequestMapping(path = "/getCompanyPrice/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StockPrice>> getPrice(@PathVariable String id) {
		return ResponseEntity.ok(stockPriceService.getPrices(id));
	}
	
	@RequestMapping(path = "/getCompanyPrice/{id}/{from}/{to}", method = RequestMethod.GET)
	public ResponseEntity<List<StockPrice>> getPriceInPeriod(@PathVariable String id, @PathVariable String from, @PathVariable String to) {
		return ResponseEntity.ok(stockPriceService.getPriceInPeriod(id,from,to));
	}

	@RequestMapping(path = "/addCompany", method = RequestMethod.POST)
	public void addNewCompany(@RequestBody Company company) {
		companyService.addCompany(company);
	}

	@RequestMapping(path = "/addStockPrice", method = RequestMethod.POST)
	public void addStockPrice(@RequestBody StockPrice stockPrice) {
		stockPriceService.addStockPrice(stockPrice);
	}

	@RequestMapping(path = "/match/{pattern}", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> getMatchingCompanies(@PathVariable String pattern) {
		return ResponseEntity.ok(companyService.getMatchingCompanies(pattern));
	}

	@RequestMapping(path = "/company/{id}", method = RequestMethod.GET)
	public ResponseEntity<Company> getCompanyDetails(@PathVariable String id) {
		return ResponseEntity.ok(companyService.getCompanyDetails(id));
	}

	@RequestMapping(path = "/getIpo", method = RequestMethod.GET)
	public ResponseEntity<List<IPODetails>> findAll() {
		return ResponseEntity.ok(ipoService.findAll());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<IPODetails> findById(@PathVariable String id){
		IPODetails ipo = ipoService.findById(id);
		return ResponseEntity.ok(ipo);
	}

	@RequestMapping(path = "addIpo", method = RequestMethod.POST)
	public ResponseEntity<IPODetails> save(@RequestBody IPODetails ipo) {
		IPODetails addedIpo = ipoService.save(ipo);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedIpo);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public ResponseEntity<IPODetails> update(@RequestBody IPODetails ipoDto)  {
		IPODetails updatedIpoDto = ipoService.update(ipoDto);
		return ResponseEntity.ok(updatedIpoDto);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		ipoService.deleteById(id);
	}
}
