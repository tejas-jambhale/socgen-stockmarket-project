package com.project.companyservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.companyservice.dto.IPODto;
import com.project.companyservice.model.IPODetails;

@Service
public interface IpoService 
{
	public List<IPODetails> findAll();
	public IPODetails findById(String id);
	public IPODetails save(IPODetails ipo);
	public IPODetails update(IPODetails ipo);
	public void deleteById(String id);
	public void addNewIpo(IPODto ipo);
}
