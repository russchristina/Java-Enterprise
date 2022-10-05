package com.revature;

import java.io.FileNotFoundException;

/**
 * 
 * We've already seen several exceptions in Java. Java has built-in exception handling. In other
 * words, if something goes wrong, we usually almost immediately know about it.
 * 
 * An exception is generally thought of a disruption in the normal flow of an application that can
 * be reasonably recovered from.
 * 
 * There are 2 categories of exceptions in Java: checked and unchecked (runtime) exceptions.
 * 
 * Unchecked exceptions are exceptions that extend RuntimeException. These exceptions do not have
 * to be handled, meaning that we don't have to do anything to accommodate for the fact that these
 * exceptions might be thrown (e.g. ArrayIndexOutOfBoundsException ClassCastException).
 * 
 * Checked exceptions have to be handled. If they are not, your code will not compile (e.g.
 * FileNotFoundException, IOException, SQLException).
 * 
 * @author Christina
 *
 */
public class Exceptions {

	public static void main(String[] args){
		
		try {
			Exceptions.throwAnException();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			/*
			 * A finally block is an optional addition. A finally block always runs (unless of 
			 * course there is an unrecoverable error). These are frequently used to perform
			 * necessary cleanup (closing DB connections, closing file streams).
			 */
			System.out.println("I always run.");
		}
		
	}
	
	/*
	 * The "throws" keyword indicates that we want to force the caller (which is "main" in this case)
	 * to handle the FileNotFoundException.
	 */
	public static void throwAnException() throws FileNotFoundException{
		throw new FileNotFoundException();
	}
}

class ChristinaException extends Exception{
	
	public ChristinaException(String message) {
		super(message);
	}
}
