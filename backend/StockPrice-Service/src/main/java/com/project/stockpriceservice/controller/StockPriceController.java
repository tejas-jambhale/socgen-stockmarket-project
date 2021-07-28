package com.project.stockpriceservice.controller;

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

import com.project.stockpriceservice.model.StockPrice;
import com.project.stockpriceservice.service.StockPriceService;
import com.project.stockpriceservice.dto.StockPriceDTO;

@RestController
@EnableDiscoveryClient
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/stockPrice")
public class StockPriceController 
{
	@Autowired
	private StockPriceService stockPriceService;
	
	@RequestMapping(path = "/getAllPrices", method=RequestMethod.GET)
	public ResponseEntity<List<StockPrice>> findAll() {
		return ResponseEntity.ok(stockPriceService.findAll());
	}
	
	@RequestMapping(path = "/getPrice/{id}", method=RequestMethod.GET)
	public ResponseEntity<StockPrice> findById(@PathVariable String id)
	{
		StockPrice stockPrice = stockPriceService.findById(id);
		return ResponseEntity.ok(stockPrice);
	}
	
	@RequestMapping(path = "/addNew", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody List<StockPrice> stockPrice) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(stockPriceService.save(stockPrice));
	}
	
	@RequestMapping(path = "/addNewStockPriceList", method=RequestMethod.POST)
	public void saveList(@RequestBody List<StockPriceDTO> stockPriceDTO) {
		stockPriceService.saveList(stockPriceDTO);
	}
	
	
	@RequestMapping(path = "/update", method=RequestMethod.PUT)
	public ResponseEntity<StockPrice> update(@RequestBody StockPrice stockPrice)
	{
		StockPrice updatedStockPrice = stockPriceService.update(stockPrice);
		return ResponseEntity.ok(updatedStockPrice);
	}
	
	@RequestMapping(path = "/delete/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		stockPriceService.deleteById(id);
	}
	
	@RequestMapping(path = "/getSectorPrices/{sectorname}/{exchange}/{from}/{to}", method=RequestMethod.GET)
	public ResponseEntity<List<StockPrice>> getSectorStockPrices(@PathVariable String sectorname, @PathVariable String exchange, @PathVariable String from, @PathVariable String to)
	{
		List<StockPrice> stockPrice = stockPriceService.getSectorStockPrices(sectorname, exchange, from, to);
		return ResponseEntity.ok(stockPrice);
	}
	
	@RequestMapping(path = "/getCompanyPrices/{companyname}/{exchange}/{from}/{to}", method=RequestMethod.GET)
	public ResponseEntity<List<StockPrice>> getCompanyStockPrices(@PathVariable String companyname, @PathVariable String exchange, @PathVariable String from, @PathVariable String to)
	{
		List<StockPrice> stockPrice = stockPriceService.getCompanyStockPrices(companyname, exchange, from, to);
		return ResponseEntity.ok(stockPrice);
	}
	
}
