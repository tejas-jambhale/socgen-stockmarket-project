package com.project.sectorservice.service;

import java.util.List;

import com.project.sectorservice.model.Sector;

public interface SectorService{
	public List<String> getCompanyList(String id);
	public Sector getSectorDetails(String id);
}