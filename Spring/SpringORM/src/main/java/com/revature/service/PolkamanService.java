package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Polkaman;
import com.revature.repository.PolkamanRepository;

/**
 * The @Service stereotype is used to denote that a class deals with business logic. Again,
 * as I mentioned before, we can always use the generic @Component stereotype, but this is
 * not great practice.
 */
@Service("polkamanService")
/*
 * If you're using Spring-managed sessions, you ordinarily mark a any code (as this
 * annotation can be used at the class or method level) that potentially begins
 * multiple transactions.
 */
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
	
	public Optional<Polkaman> findOne(int id) {
		/*
		 * In Java, the Optional type is designed to provide a less verbose syntax
		 * for dealing with situations in which you are not sure that you will return
		 * an object or null.
		 */
		Optional<Polkaman> retrievedPolkaman = Optional.empty();
		List<Polkaman> allPolkamans = this.polkamanRepository.findAll();
		for(Polkaman p : allPolkamans) {
			if(p.getId() == id) retrievedPolkaman = Optional.of(p);
		}
		return retrievedPolkaman;
	}
	
	public List<Polkaman> findAllBetween(int id1, int id2){
		List<Polkaman> polkamansInRange = new ArrayList<>();
		List<Polkaman> allPolkamans = this.polkamanRepository.findAll();
		
		for(Polkaman p : allPolkamans) {
			if(p.getId() > id1 && p.getId() < id2) polkamansInRange.add(p);
		}
		
		return polkamansInRange;
	}
	
	@Transactional
	public void save(Polkaman p) {
		this.polkamanRepository.save(p);
	}
}
