package com.project.sectorservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.sectorservice.model.Sector;

@Repository
public interface SectorRepository extends MongoRepository<Sector, String>{
	public Optional<Sector> findById(String id);		
}