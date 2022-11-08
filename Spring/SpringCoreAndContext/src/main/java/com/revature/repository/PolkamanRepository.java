package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Polkaman;

/**
 * This is a mock repository that returns mock Polkamans to the callers of the methods
 * located here.
 * @author 17084
 *
 */
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
