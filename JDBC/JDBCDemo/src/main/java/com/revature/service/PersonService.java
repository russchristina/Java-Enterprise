package com.revature.service;

import java.util.Collections;
import java.util.List;

import com.revature.model.Person;
import com.revature.repository.PersonRepository;

public class PersonService {

	/*
	 * This is a dependency of the PersonService class. The PersonService depends on the
	 * PersonRepository object to perform its job properly.
	 */
	private PersonRepository personRepository;
	
	public PersonService() {
		this.personRepository = new PersonRepository();
	}
	
	public List<Person> sortPeopleByName(){
		List<Person> retrievedPeople = this.personRepository.findAll();
		Collections.sort(retrievedPeople, (p1, p2) -> p1.getPerson_name().compareTo(p2.getPerson_name()));
		return retrievedPeople;
	}
}
