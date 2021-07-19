package com.project.sectorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sectorservice.model.Sector;
import com.project.sectorservice.service.SectorService;

@RestController
class SectorServiceController{
	
	@Autowired
	SectorService sectorService;
	
	@RequestMapping(path="/getsectorcompanies", method=RequestMethod.GET )
	public ResponseEntity<List<String>> getList(@RequestParam String id){
		return ResponseEntity.ok(sectorService.getCompanyList(id));
	}
	
	@RequestMapping(path="/getsectordetails", method=RequestMethod.GET)
	public ResponseEntity<Sector> getSectorDet(@RequestParam String id){
		return ResponseEntity.ok(sectorService.getSectorDetails(id));
	}
	
}