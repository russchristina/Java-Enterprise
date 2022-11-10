package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Polkaman;
import com.revature.repository.PolkamanRepository;

@Service("polkamanService")
@Transactional
public class PolkamanService {
	
	@Autowired
	private PolkamanRepository polkamanRepository;
	
	public List<Polkaman> findAll(){
		return this.polkamanRepository.findAll();
	}
	
	public Optional<Polkaman> findOne(int id) {	
		return this.polkamanRepository.findById(id);
	}
	
	public List<Polkaman> findAllBetween(int id1, int id2){
		return this.polkamanRepository.findByIdBetween(id1, id2);
	}
	
	public void save(Polkaman p) {
		this.polkamanRepository.save(p);
	}
}
