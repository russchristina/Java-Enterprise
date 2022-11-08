package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
	
	private static List<Polkaman> polkamans;

	public PolkamanRepository() {
		polkamans = new ArrayList<>();
		polkamans.add(new Polkaman(1, "pekachu", "electric"));
		polkamans.add(new Polkaman(2, "ice cream polkaman", "ice"));
		polkamans.add(new Polkaman(3, "busted fairy type polkaman", "fairy"));
	}
	
	
	public List<Polkaman> findAll(){
		return polkamans;
	}
	
	
	
}
