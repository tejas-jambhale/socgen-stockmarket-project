package com.project.sectorservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sectorservice.model.Company;
import com.project.sectorservice.model.Sector;
import com.project.sectorservice.repository.SectorRepository;
import com.project.sectorservice.service.SectorService;

@Service
class SectorServiceImpl implements SectorService{
	
	@Autowired
	SectorRepository sectorRepository;
	
	public List<Company> getCompanyList(String id){
		Optional<Sector> sectOpt = sectorRepository.findById(id);
		Sector sect =  sectOpt.get();
		return sect.getCompanies();
	}
	
	public Sector getSectorDetails(String id) {
		Optional<Sector> sectOpt = sectorRepository.findById(id);
		return sectOpt.get();
	}
}