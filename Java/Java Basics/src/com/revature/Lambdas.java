package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Lambdas {
	
	public static void main(String...args) {

	/**
	 * A lambda expression allows you to treat a method implementation as an object in Java. This
	 * means that you can pass a function to a method as argument or store a method implementation
	 * using a reference variable. Lambdas were introduced in Java 8.
	 * 
	 * Lambda expressions do require the use of a functional interface. A functional interface
	 * must be used as the type for the variable that points to a lambda expression (your
	 * function).
	 * 
	 * Common functional interfaces include:
	 * 
	 * Consumer
	 * Supplier
	 * Predicate
	 * BiPredicate
	 * Function
	 * BiFunction
	 */
	
	MyFunctionalInterface addition = (num1, num2) -> num1 + num2;
	MyFunctionalInterface subtraction = (int num1, int num2) -> {return num1 + num2;};
	
	List<String> myStrings = new ArrayList<>();
	myStrings.add("christina");
	myStrings.add("richard");
	myStrings.add("rory");
	myStrings.add("numair");
	
	myStrings.removeIf(stringObj -> stringObj.contains("i"));
	myStrings.forEach(stringObj -> System.out.println(stringObj));
	
	}
	
	
}
