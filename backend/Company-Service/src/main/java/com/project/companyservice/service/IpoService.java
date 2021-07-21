package com.project.companyservice.service;

import java.util.List;

import com.project.companyservice.model.IPODetails;

public interface IpoService 
{
	public List<IPODetails> findAll();
	public IPODetails findById(String id);
	public IPODetails save(IPODetails ipo);
	public IPODetails update(IPODetails ipo);
	public void deleteById(String id);
}
