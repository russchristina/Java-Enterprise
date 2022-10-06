package com.revature.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.revature.Sum;

/*
 * JUnit is arguably the most popular testing framework in Java. JUnit is currently on version 5.
 * It is considered easy to use as it very annotation driven.
 * 
 * It is considered a framework as it takes the test code that we provide to it and provides all of
 * the logic for running the tests in a specific order, running tests around sets of data, etc. JUnit,
 * for instance, will make an instance of my test class and call all of the methods that are annoted
 * with @Test, @BeforeAll, etc.
 * 
 * Testing is not something "new" to us. We all know how to test deep down as we know how to compare
 * the actual result to the expected result.
 */

@TestInstance(Lifecycle.PER_CLASS)
public class SumTest {
	
	private Sum sum;
	
	/*
	 * JUnit provides options for setting up a test suite. These come in the form of annotations.
	 */
	@BeforeAll //runs a single time before any other methods in the suite
	public void setUp() {
		/*
		 * If I want to test the method(s) on the Sum class, I need an instance of the Sum class.
		 */
		sum = new Sum();
	}
	
	@BeforeEach
	public void beforeEach() { //runs once PER TEST in the suite
		
	}

	/*
	 * This method is recognized as a JUnit test as it is annotated with @Test.
	 * 
	 * Note that our Assertions class is a utility class used to easily compare the expected
	 * result to the actual result. You can have as many assertions as you want in a test.
	 * 
	 * This type of test is called a unit test as it focuses on testing the functionality of just
	 * one tiny component of an application.
	 */
	@Test
	@Disabled //This test is currently disabled.
	public void testSumMethod() {
		//Now I have to call the method to get its actual return value.
		int result = sum.add(5, 5);
		//Now use my Assertions class to compare the result to the expectation.
		Assertions.assertEquals(10, result, "The actual sum is incorrect!");
	}
	
	@Test
	public void testSumMethodLargeNumbers() {
		Assertions.assertEquals(1000000, sum.add(500000, 500000));
		
	}
	
	@AfterEach
	public void afterEach() { //runs once PER TEST (after each a test)
		
	}
	
	@AfterAll
	public void tearDown() { //runs once (after all of the other methods in this suite)
		
	}
	
	
	
}
