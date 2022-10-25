package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class JavaLists {

	/*
	 * List is one of the many subinterfaces of Collection. It is arguably one of the popular
	 * subinterfaces. The benefits of using a list include:
	 * 
	 * 1) Unlike an array, a list is resizable.
	 * 2) Implementations of List support random access. You can easily access an element using its index.
	 * 3) Lists will maintain the order of the elements as they're inserted.
	 * 4) Lists support duplicates. 
	 */
	public static void main(String[] args) {
		/*
		 * ASIDE: Generics allow us to impose compile-time safety on our types as we use them.
		 * For instance, collection implementations use generics to ensure that the elements inside
		 * of the collection are all of a similar type. Note that only object types are supported
		 * with generics. This means that you cannot use a primitive type as your generic type;
		 * you should use a wrapper class representation instead.
		 * 
		 * ArrayList is a popular choice for a List implementation. It boasts:
		 * 
		 * 1) Fast random access
		 */
		List<Integer> myList = new ArrayList<>();
		
		/*
		 * LinkedList is also a popular choice for a List implementation. Note that it is not
		 * equivalent to using an ArrayList. For instance, Java cannot as quickly access a random
		 * element in a LinkedList.
		 */
		
		List<Integer> myLinkedList = new LinkedList<>();
		
		/*
		 * As an addendum, there is also a type called Vector in Java. Note that Vector is a 
		 * thread-safe implementation List. This means that it's slower.
		 */
		List<Integer> myVector = new Vector<>();
		
		/*
		 * Note that Java autoboxes primitive data types as their wrapper class representations
		 * when you place them inside of collections. Java can also auto-unbox as well like so:
		 */
//		Integer i = 2;
//		Integer i2 = 5;
//		int sum = i + i2;
		
		myList.add(1);
		myList.add(2);
		myList.add(34);
		
		myLinkedList.add(2);
		myLinkedList.add(59);
		myLinkedList.add(4);
		
		
		//PRINT STATEMENTS
		System.out.println(myList.get(2));
	}
}
