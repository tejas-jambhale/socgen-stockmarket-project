package com.project.stockexchangeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockexchangeservice.model.StockExchange;
import com.project.stockexchangeservice.service.StockExchangeService;
import com.project.stockexchangeservice.model.Company;

@RestController
public class StockExchangeServiceController{
	
	@Autowired
	StockExchangeService stockExchangeService;
	 
	 @RequestMapping(path="/getExchangesList", method=RequestMethod.GET) 
	 public ResponseEntity<List<StockExchange>> getListOfExchanges(){
		 return ResponseEntity.ok(stockExchangeService.getExchangeList());
	 }
	 
	 @RequestMapping(path="/getExchangeData", method=RequestMethod.GET)
	 public ResponseEntity<StockExchange> getExchange(@RequestParam String id){
		 return ResponseEntity.ok(stockExchangeService.getExchangeFromId(id));
	 }	
	  
	 @RequestMapping(path="/getCompaniesFromExchange/{id}", method=RequestMethod.GET) 
	 public ResponseEntity<List<Company>> getCompaniesFromExchange(@RequestParam String id){
		 return ResponseEntity.ok(stockExchangeService.getCompanyList(id));
	 }	
	 
	 @RequestMapping(path="/addExchange", method=RequestMethod.POST)
	 public void addNewExchange(@RequestBody StockExchange stockExchange) {
		 stockExchangeService.addStockExchange(stockExchange);
	 }
	 
	 @RequestMapping(path="/updateExchange", method=RequestMethod.PUT)
	 public void updateExchange(@RequestBody StockExchange stockExchange) {
		 stockExchangeService.updateStockExchange(stockExchange);
	 }
	 
}