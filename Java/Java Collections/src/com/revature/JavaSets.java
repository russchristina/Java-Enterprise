package com.revature;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class JavaSets {
	
	//Object
	/*
	 * Set is another subinterface of Collection. Set is often contrasted with List as many of
	 * the operations a list supports a set does not:
	 * 
	 * 1) Sets do not support random access.
	 * 2) A Set does not support duplicates.
	 * 3) A Set does not guarantee that the order of insertion will be preserve
	 */

	public static void main(String[] args) {
		
		//Common implementation of Set
		Set<String> strings = new HashSet<>();
		/*
		 * Sorted Implementation of Set: TreeSet. 
		 * 
		 * A TreeSet is a sorted implementation our Set interface. It uses the elements' natural
		 * order (if your type doesn't have a natural order built-in order, you have to create it
		 * by implementing the Comparable interface). A TreeSet is a good option if you need your
		 * elements to be in their natural order and you'll be reading from the set a lot. However,
		 * if you are adding a lot of elements to the set, this is a bad option for you as the TreeSet
		 * has to stay sorted, which means that the addition of a new element means that it has to be
		 * resorted.
		 */
		Set<Circle> sortedCircles = new TreeSet<>();
	
		strings.add("a string");
		strings.add("a string");
		strings.add("more strings");
		strings.add("yet more strings");
		
		sortedCircles.add(new Circle(10));
		sortedCircles.add(new Circle(15));
		sortedCircles.add(new Circle(7));
		
		
		//PRINT STATEMENTS
		System.out.println(strings.size());
		
		/*
		 * If you wish to access a specific element, you need to iterate over the Set.
		 */
		//Object
		for(String s : strings) {
			if(s.equals("more strings")) System.out.println(s);
		}
		
		//Using an iterator
		
		Iterator<String> it = strings.iterator();
		
		while(it.hasNext()) {
			String nextEl = it.next();
			if(nextEl.equals("more strings")) System.out.println(nextEl);
		}
		
		System.out.println(sortedCircles);
		
	}
}

//Companion class for TreeSet example
class Circle implements Comparable<Circle>{
	private int diameter;
	
	public Circle(int diameter) {
		this.diameter = diameter;
	}

	@Override
	public int compareTo(Circle o) {
		return this.diameter - o.diameter;
	}

	@Override
	public String toString() {
		return "Circle [diameter=" + diameter + "]";
	}
}
