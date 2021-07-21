package com.project.sectorservice.service;

import java.util.List;

import com.project.sectorservice.model.Company;
import com.project.sectorservice.model.Sector;

public interface SectorService{
	public List<Company> getCompanyList(String id);
	public Sector getSectorDetails(String id);
	public void addCompanyToSector(String sectorName, Company company);
}