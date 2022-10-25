package com.revature;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaQueues {

	/*
	 * A Queue follows a first in, first out (FIFO) policy. The first element in a queue is the first element
	 * that will be removed from the queue. Queue itself is an interface (a subinterface of Collection).
	 */
	
	public static void main(String[] args) {
		
		/*
		 * This implementation of queue in particular is backed by an array, and it is bounded.
		 * This means that the size of the backing array is used as a limitation; this queue 
		 * cannot have more than 15 elements.
		 */
		final Queue<String> line = new ArrayBlockingQueue<>(15);
		
		line.add("person 1");
		line.add("person 2");
		line.add("person 3");
		
		String removedObject = line.poll();
		line.remove();
		
		System.out.println(line);
		
		/*
		 * In contrast to a queue, you can also use a Stack. A Stack follows a First in, last out 
		 * (FILO).
		 * 
		 * It is recommended that you do not use the Stack type as it is not an ideal Stack. You
		 * should instead a double ended queue (Deque).
		 */
		
		//DO NOT USE
		Stack<String> myStack = new Stack<>();
		
		myStack.add("element 1");
		myStack.add("element 2");
		myStack.add("element 3");
		
		myStack.remove(1);
		
		//USE THIS INSTEAD
		Deque<String> myDeque = new ArrayDeque<>();
		
		myDeque.addFirst("christina");
		myDeque.addLast("kim");
		myDeque.addFirst("sean");
		
		System.out.println(myDeque);
	}
	
	
}
