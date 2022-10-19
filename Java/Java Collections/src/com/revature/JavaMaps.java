package com.revature;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
 * Technically speaking, Maps aren't a "Collection" in Java.
 * 
 * Technicalities aside, a Map allows you to store a group of related elements just like your
 * average Java Collection. Maps are notable for allowing you to store key-value pairs. They work
 * like a Dictionary (an obsolete type in Java) where in order to find a value, you must use its
 * specific key.
 */
public class JavaMaps {
	
	public static void main(String[] args) {
		
		//Creating a Map
		/*
		 * HashMap is not thread-safe (to compare it with Hashtable). It does support the use of
		 * a null key. Note that a HashMap is backed by a Hashtable but this can change if need
		 * be - in which case it will be convered into a Tree.
		 */
		Map<String, String> dictionary = new HashMap<>(); //HashMap
		/*
		 * Hashtable is actually a legacy class. Unlike HashMap, it does not allow for the use of
		 * null keys. This is because every type that you use with a Hashtable actually must
		 * implement the hashCode and equals methods as the key is hashed. The performance is
		 * slower because Hashtable is synchronized (thread-safe).
		 */
		Map<Integer, String> employees = new Hashtable<>(); //Hashtable
		
		//Adding to a HashMap
		dictionary.put("hat", "a strange contraption that humans wear on their head");
		dictionary.put("cat", "a creature that disobeys christina while she works and cannot stop here");
		dictionary.put("work", "the process of contributing to society, though it feels torturous to get out of bed in the morning");
//		dictionary.put("hat", "overwritten defintion");
		dictionary.putIfAbsent("hat", "will not overwrite my existing value");
		dictionary.put(null, "some value"); //you can even have a null key in your HashMap
		//Adding to a Hashtable
		employees.put(1, "christina");
		employees.put(null, "sean"); //This throws an exception
		
		
		//Removing an element
		dictionary.remove("cat");
		//Using the BiConsumer functional interface to print out all of the elements of a Map
		dictionary.forEach((key, value) -> System.out.println(key + ":" + value));
		dictionary.forEach((key, value) -> System.out.println(key + ":" + value));
		
		/*
		 * Maps in Java are not iterable. This means that you can't use the for each syntax with
		 * maps. As a result, you typically would get the keys as a Set using the keySet method.
		 */
		for(String key : dictionary.keySet()) {
			System.out.println(key + ":" + dictionary.get(key));
		}
		
		System.out.println(dictionary);
		System.out.println(employees);
	}

}
