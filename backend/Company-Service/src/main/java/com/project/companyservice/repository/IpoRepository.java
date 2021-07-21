package com.project.companyservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.companyservice.model.IPODetails;

@Repository
public interface IpoRepository extends MongoRepository<IPODetails, String>
{
	public Optional<IPODetails> findById(String id);
	public void deleteById(String id);
}
