package com.revature.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Polkaman;

/**
 * This is a mock repository that returns mock Polkamans to the callers of the methods
 * located here.
 * @author 17084
 *
 */

/**
 * 
 * There is another way of adding beans to your IOC container. You can use Spring stereotypes
 * to mark specific classes so that Spring knows that it should manage instances of these
 * classes as beans.
 * 
 * The @Repository stereotype marks a class as a class that interacts with a data source.
 *
 * We can give the bean a name by using the "value" attribute OR just putting the name
 * inside of the parentheses as a String.
 */
@Repository("polkamanRepository")
public class PolkamanRepository {
	
	/*
	 * This wires in our entity manager from our IOC container.
	 * Fix transaction manager.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Polkaman> findAll(){
		return this.entityManager.createQuery("FROM Polkaman", Polkaman.class).getResultList();
	}
	
	public void save(Polkaman p) {
		this.entityManager.persist(p);
	}
	
	
	
}
