package com.revature;


public class Strings {

	public static void main(String[] args) {
		
		/*
		 * A String is a representation of what we think of as "text". Note that a String is just
		 * a char[].
		 * 
		 * Even though the String class has a constructor that you can use, it is not recommended to
		 * use that constructor because 1) it's more verbose when we can just use a String literal and
		 * 2) it is less memory efficient to use the constructor as this forces the creation of a new
		 * String object.
		 * 
		 * All Strings are handled in a special way. They are stored on the heap in a special pool called
		 * the "String Pool". If you use the String literal syntax, Java will check the pool for the existence
		 * of the underlying String. If it already exists, Java will just reuse the existing String.
		 */
		
		String blah = "Blah Blah"; //does not necessarily always create a String
		String blahAgain = new String("Blah Blah"); //this always creates a new String
		String blahThrice = "Blah Blah"; //does NOT create a new String
		
		System.out.println(blah == blahThrice); //this is true because of the String pool
		
		/*
		 * Strings are also "immutable". This means that you can't change a String object.
		 * As such, many of the methods on the String API return an entirely new String to
		 * the caller.
		 * 
		 * Also note that String is a final class in Java. This means that you cannot extend it.
		 */
		
		blah = blah.concat(" blah blah").toUpperCase().replace('A', 'E');
		
		System.out.println(blah + " using + operator");
		
		/*
		 * As a note, you can use either StringBuilder or StringBuffer (if you're multithreading)
		 * in place of String. Both types allow you to feel as if you're using a "mutable String".
		 * Note that they're both actually just wrappers around the String type.
		 */
		
		StringBuilder sb = new StringBuilder("New String");
		sb.append(" appended text");
		System.out.println(sb);
	
	}
}
