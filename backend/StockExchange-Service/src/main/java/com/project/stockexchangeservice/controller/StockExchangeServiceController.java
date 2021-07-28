package com.project.stockexchangeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockexchangeservice.model.StockExchange;
import com.project.stockexchangeservice.service.StockExchangeService;

import io.swagger.annotations.ApiOperation;

import com.project.stockexchangeservice.model.Company;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/stockExchange")
public class StockExchangeServiceController{
	
	@Autowired
	StockExchangeService stockExchangeService;
	 
	
	 @RequestMapping(path="/getExchangesList", method=RequestMethod.GET) 
	 @ApiOperation("Returns list of exchanges added till date")
	 public ResponseEntity<List<StockExchange>> getListOfExchanges(){
		 return ResponseEntity.ok(stockExchangeService.getExchangeList());
	 }
	 
	 @RequestMapping(path="/getExchangeData/{id}", method=RequestMethod.GET)
	 @ApiOperation("Returns Exchange based on id")
	 public ResponseEntity<StockExchange> getExchange(@PathVariable String id){
		 return ResponseEntity.ok(stockExchangeService.getExchangeFromId(id));
	 }	
	  
	 @RequestMapping(path="/getCompaniesFromExchange/{id}", method=RequestMethod.GET) 
	 @ApiOperation("Returns all companies belonging to exchange with given id")
	 public ResponseEntity<List<Company>> getCompaniesFromExchange(@PathVariable String id){
		 return ResponseEntity.ok(stockExchangeService.getCompanyList(id));
	 }	
	 
	 @RequestMapping(path="/addExchange", method=RequestMethod.POST)
	 @ApiOperation("Adds new exchange")
	 public void addNewExchange(@RequestBody StockExchange stockExchange) {
		 stockExchangeService.addStockExchange(stockExchange);
	 }
	 
	 @RequestMapping(path="/updateExchange", method=RequestMethod.PUT)
	 @ApiOperation("Updates existing exchange")
	 public void updateExchange(@RequestBody StockExchange stockExchange) {
		 stockExchangeService.updateStockExchange(stockExchange);
	 }
	 
	 @RequestMapping(path="/addCompanyToExchange/{exchangename}", method=RequestMethod.POST)
	 @ApiOperation("Adds a company to given exchange name")
		public void addCompanytoExchange(@PathVariable String exchangename, @RequestBody Company company) {
			stockExchangeService.addCompanyToExchange(exchangename, company);
		}
	 
	 @RequestMapping(path="/deleteExchange/{id}", method=RequestMethod.DELETE)
	 @ApiOperation("Deletes exchange with given id")
	 public void deleteExchange(@PathVariable String id) {
		 stockExchangeService.deleteExchange(id);
	 }
	 
}