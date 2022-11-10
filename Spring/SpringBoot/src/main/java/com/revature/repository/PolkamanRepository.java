package com.revature.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Polkaman;

/*
 * @When you create a SpringBoot, you do NOT typically set up your own entity manager
 * or create or create your own data source beans. You typically see Spring Data JPA
 * used with Spring Boot projects.
 * 
 * The Spring Data JPA module almost completely abstracts away your persistence layer.
 * You do not need to be concerned with supplying implementations for the methods in
 * your repository. In fact, JPA provides the implementations for you. As such, you
 * only need to create an interface for your repository. This interface should extend
 * the JpaRepository, which provides a collection of common CRUD methods that you
 * usually implement.
 */
@Repository("polkamanRepository")
public interface PolkamanRepository extends JpaRepository<Polkaman, Integer>{

	List<Polkaman> findAll();
	/*
	 * Spring Data JPA should be able to provide the implementation at runtime as long
	 * as I'm using the expression language for method naming properly.
	 * 
	 * What if we wanted to slightly modify the behavior of a method here? This is possible
	 * using the @Query annotation. In this example, we've slightly modified the behavior
	 * of the method to return a non-inclusive range.
	 */
	
	@Query("select p from Polkaman p where p.id > ?1 and p.id < ?2")
	List<Polkaman> findByIdBetween(int id1, int id2);
}
