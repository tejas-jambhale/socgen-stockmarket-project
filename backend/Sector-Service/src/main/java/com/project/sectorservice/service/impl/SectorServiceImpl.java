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
class SectorServiceImpl implements SectorService {

	@Autowired
	SectorRepository sectorRepository;

	public List<Sector> getAll(){
		return sectorRepository.findAll();
	}
	
	public List<Company> getCompanyList(String id) {
		Optional<Sector> sectOpt = sectorRepository.findById(id);
		Sector sect = sectOpt.get();
		return sect.getCompanies();
	}

	public Sector getSectorDetails(String id) {
		Optional<Sector> sectOpt = sectorRepository.findById(id);
		return sectOpt.get();
	}

	public void addCompanyToSector(String sectorName, Company company) {
		Sector sector = sectorRepository.findByName(sectorName);
		if (sector != null) {
			if (sector.getCompanies()==null) {
				sector.setCompanies(Arrays.asList(company));
				sector = sectorRepository.save(sector);
			}
			else {
			sector.getCompanies().add(company);
			sector = sectorRepository.save(sector);
			}
		}
	}
	
	public void addNewSector(Sector sector) {
		sectorRepository.save(sector);
	}
	
	public void update(Sector sector) {
		if(sectorRepository.findById(sector.getId()) != null)
			sectorRepository.save(sector);
	}
	
	public void deleteSector(String id) {
		if(sectorRepository.findById(id)!=null)
			sectorRepository.deleteById(id);
	}
}