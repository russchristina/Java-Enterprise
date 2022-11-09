package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Polkaman;
import com.revature.repository.PolkamanRepository;

/**
 * The @Service stereotype is used to denote that a class deals with business logic. Again,
 * as I mentioned before, we can always use the generic @Component stereotype, but this is
 * not great practice.
 */
@Service("polkamanService")
public class PolkamanService {

	/*
	 * This type of injection is called field injection whereby the framework injects
	 * the dependency at the field level.
	 */
	@Autowired
	private PolkamanRepository polkamanRepository;
	
	/*
	 * We can also use the constructor as a point of dependency injection.
	 */
//	@Autowired
//	public PolkamanService(PolkamanRepository polkamanRepository) {
//		this.polkamanRepository = polkamanRepository;
//	}
	
	/*Spring's default way of passing a dependency is via a class's setter. Yes, the
	 * setter name has to be "conventional". If it is not, Spring considers this an 
	 * invalid setter name. We refer to this as "convention over configuration"; when
	 * using a framework, you're often locked into following certain conventions.
	 * 
	 * The @Autowired annotation tells Spring to supply a dependency via the setter in
	 * this case.
	 */
//	@Autowired
//	public void setPolkamanRepository(PolkamanRepository polkamanRepository) {
//		this.polkamanRepository = polkamanRepository;
//	}
	
	public List<Polkaman> findAll(){
		return this.polkamanRepository.findAll();
	}
}
