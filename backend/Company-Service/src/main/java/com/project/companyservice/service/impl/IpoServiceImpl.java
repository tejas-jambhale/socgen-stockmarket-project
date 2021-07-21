package com.project.companyservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.model.IPODetails;
import com.project.companyservice.repository.IpoRepository;
import com.project.companyservice.service.IpoService;

@Service
public class IpoServiceImpl implements IpoService
{
	@Autowired
	private IpoRepository ipoRepository;
	
	@Override
	public List<IPODetails> findAll() {
		List<IPODetails> ipos = ipoRepository.findAll();
		return ipos;
	}
	
	@Override
	public IPODetails findById(String id) {
		Optional<IPODetails> ipo = ipoRepository.findById(id);
		if(!ipo.isPresent())
			return null;
		return ipo.get();
	}
	
	@Override
	public IPODetails save(IPODetails ipo) {
		ipo = ipoRepository.save(ipo);
		return ipo;
	}
	
	@Override
	public IPODetails update(IPODetails ipo) {
		if(findById(ipo.getId()) == null)
			return null;
		IPODetails finalIpo = ipoRepository.save(ipo);
		return finalIpo;
	}
	
	@Override
	public void deleteById(String id) {
		ipoRepository.deleteById(id);
	}
}
