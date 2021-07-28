package com.project.stockpriceservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.stockpriceservice.model.Sector;

@Repository
public interface SectorRepository extends MongoRepository<Sector, String> {
	public Sector findByName(String sectorname); 
}
