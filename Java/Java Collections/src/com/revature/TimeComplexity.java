package com.revature;

import java.util.ArrayList;
import java.util.List;

/*
 * In general, there are several ways to measure "efficiency" of an algorithm. Efficiency can refer
 * to, for instance, speed or resource management.
 */
public class TimeComplexity {
	
	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(5);
		nums.add(90);
		nums.add(0);
		nums.add(-1);
		
		//Linear Search O(n)
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) == 0) System.out.println("found it");
		}
		
		//Binary Search
	}

}
