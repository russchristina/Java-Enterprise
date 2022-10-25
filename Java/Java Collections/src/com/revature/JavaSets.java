package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
		
		/*
		 * Typically, you would use a Comparator to compare a type in a different way than
		 * you had used Comparable to compare instances of that type. In any case, lamdba
		 * expressions can really reduce the number of Comparator classes you create. 
		 */
		CircleComparator circleComparator = new CircleComparator();
		Circle c1 = new Circle(4);
		Circle c2 = new Circle(89);
		circleComparator.compare(c1, c2);
		
		//List created for demo purposes:
		List<Circle> circles = new ArrayList<>();
		circles.add(c1);
		circles.add(c2);
		
		//Observe that we can just use a lambda expression for the one abstract method on the
		//Comparator interface:
		Collections.sort(circles, (o1, o2) -> o1.diameter - o2.diameter);
		
		/*
		 * Bonus: Streams. A Stream in Java allows you to perform several intermediate operations
		 * on the elements of that stream and reductions (these are terminal operations however).
		 * Please note that once you perform a terminal operation on a stream of elements, that
		 * stream is closed.
		 */
		
		List<Integer> integers = Arrays.asList(3, 4, 34, 2, 566);
		//ToIntFunction: A functional interface that makes performing arithmetic on the elements
		//of an IntStream quite simple. This is an example of using an IntStream to quickly sum
		//the values inside of the stream.
		integers.stream().mapToInt((num) -> num.intValue()).sum();
		
	}
}

//Companion class for TreeSet example
class Circle implements Comparable<Circle>{
	int diameter;
	
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

class CircleComparator implements Comparator<Circle>{

	@Override
	public int compare(Circle o1, Circle o2) {
		return o1.diameter - o2.diameter;
	}
}
