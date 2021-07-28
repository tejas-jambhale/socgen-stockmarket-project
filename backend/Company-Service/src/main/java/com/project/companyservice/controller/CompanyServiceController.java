package com.project.companyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.companyservice.dto.IPODto;
import com.project.companyservice.model.Company;
import com.project.companyservice.model.IPODetails;
import com.project.companyservice.model.StockPrice;
import com.project.companyservice.service.CompanyService;
import com.project.companyservice.service.IpoService;
import com.project.companyservice.service.StockPriceService;

@RestController
@EnableDiscoveryClient
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/company")
class CompanyServiceController {
	
	@Autowired
	CompanyService companyService;

	@Autowired
	StockPriceService stockPriceService;

	@Autowired
	private IpoService ipoService;
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> getCompany(){
		return ResponseEntity.ok(companyService.getAllCompanies());
	}

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

	@RequestMapping(path = "/getCompany/{id}", method = RequestMethod.GET)
	public ResponseEntity<Company> getCompanyDetails(@PathVariable String id) {
		return ResponseEntity.ok(companyService.getCompanyDetails(id));
	}
	
	@RequestMapping(path = "/update/", method = RequestMethod.PUT)
	public ResponseEntity<Company> updateCompany(@RequestBody Company company){
		return ResponseEntity.ok(companyService.updateCompany(company));
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteCompany(@PathVariable String id){
		companyService.deleteCompany(id);
	}


	@RequestMapping(path = "/ipo/getIpo", method = RequestMethod.GET)
	public ResponseEntity<List<IPODetails>> findAll() {
		return ResponseEntity.ok(ipoService.findAll());
	}

	@RequestMapping(path = "/ipo/{id}", method = RequestMethod.GET)
	public ResponseEntity<IPODetails> findById(@PathVariable String id){
		IPODetails ipo = ipoService.findById(id);
		return ResponseEntity.ok(ipo);
	}

	@RequestMapping(path = "/ipo/addIpo", method = RequestMethod.POST)
	public ResponseEntity<IPODetails> save(@RequestBody IPODetails ipo) {
		IPODetails addedIpo = ipoService.save(ipo);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedIpo);
	}
	
	@RequestMapping(path = "/ipo/add", method = RequestMethod.POST)
	public void save(@RequestBody IPODto ipo) {
		ipoService.addNewIpo(ipo);
	}

	@RequestMapping(path = "/ipo/update", method = RequestMethod.PUT)
	public ResponseEntity<IPODetails> update(@RequestBody IPODetails ipoDto)  {
		IPODetails updatedIpoDto = ipoService.update(ipoDto);
		return ResponseEntity.ok(updatedIpoDto);
	}

	@RequestMapping(path = "/ipo/delete/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		ipoService.deleteById(id);
	}
}
