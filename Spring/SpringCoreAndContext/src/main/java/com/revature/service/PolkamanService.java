package com.revature.service;

import java.util.List;

import com.revature.model.Polkaman;
import com.revature.repository.PolkamanRepository;

public class PolkamanService {

	private PolkamanRepository polkamanRepository;
	
	public PolkamanService() {
		this.polkamanRepository = new PolkamanRepository();
	}
	
	public List<Polkaman> findAll(){
		return this.polkamanRepository.findAll();
	}
}
