package com.project.sectorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sectorservice.model.Company;
import com.project.sectorservice.model.Sector;
import com.project.sectorservice.service.SectorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/sector")
class SectorServiceController{
	
	@Autowired
	SectorService sectorService;
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public ResponseEntity<List<Sector>> getAll(){
		return ResponseEntity.ok(sectorService.getAll());
	}
	
	@RequestMapping(path="/getSectorCompanies/{id}", method=RequestMethod.GET )
	public ResponseEntity<List<Company>> getList(@PathVariable String id){
		return ResponseEntity.ok(sectorService.getCompanyList(id));
	}
		
	@RequestMapping(path="/getSectorDetails/{id}", method=RequestMethod.GET)
	public ResponseEntity<Sector> getSectorDet(@PathVariable String id){
		return ResponseEntity.ok(sectorService.getSectorDetails(id));
	}
	
	@RequestMapping(path="/addCompanyToSector/{sectorname}", method=RequestMethod.POST)
	public void addCompanytoSector(@PathVariable String sectorname, @RequestBody Company company) {
		sectorService.addCompanyToSector(sectorname, company);
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public void addSector(@RequestBody Sector sector) {
		sectorService.addNewSector(sector);
	}
	
	@RequestMapping(path="/update", method=RequestMethod.PUT)
	public void updateSector(@RequestBody Sector sector) {
		sectorService.update(sector);
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteSector(@PathVariable String id) {
		sectorService.deleteSector(id);
	}
}