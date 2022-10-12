package com.revature;

import java.util.Properties;

import com.revature.model.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	/*
	 * As JDBC is an interface against which programmers must program, 
	 * the basic types you encounter are typically interfaces that are
	 * built into java. These include:
	 * 
	 * Connection
	 * Statement
	 * Prepared Statement
	 * Result Set
	 * SQLException(this is a class)
	 * DriverManager(this is also a class)
	 */
	
	public static void printPeople() throws SQLException{
		
		//Make necessary Objects
		ResultSet set = null;
		Statement stmt = null;
		Connection conn = null;
		
		try{
			
			//Make Connection
			conn = DriverManager.getConnection(
					System.getenv("DB_URL"), 
					System.getenv("DB_username"), 
					System.getenv("DB_password"));
			
			//Create statement
			stmt = conn.createStatement();
			
			//Execute Statement
			set = stmt.executeQuery("SELECT * FROM person");
			
			//Print out column labels
			System.out.printf("%5s", "id");
			System.out.printf("%10s", "name");
			System.out.printf("%10s", "age");
			System.out.printf("%15s", "State");
			System.out.printf("%20s\n", "Favorite Color");
			
			//Print line to separate labels from results
			System.out.println("-".repeat(60));
			
			
			//Print results line by line
			while(set.next()) {
				System.out.printf("%5s", set.getInt(1));
				System.out.printf("%10s", set.getString(2));
				System.out.printf("%10s", set.getInt(3));
				System.out.printf("%15s", set.getString(4));
				System.out.printf("%20s\n", set.getString(5));
				}
			}
			
			//Catch whoopsies
			catch(SQLException e){
				e.printStackTrace();
			}
			
			//Cleanup
			finally {
				
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	
	public static void main(String[] args) {
		/*
		 * Let's do a standard JDBC Workflow in which we connect to
		 * our DB, pull out a single record, then close the connection.
		 * 
		 * We'll always need to start by getting a connection to our DB.
		 * This entails authenticating ourselves to a specific DB.
		 * The Connection interface represents this connection to a
		 * DB. It is through our connection that we are allowed to 
		 * execute statements against our DB
		 * 
		 * We use our DriverManager to obtain a connection, the 
		 * DriverManager is also responsible for letting us set
		 * driver specific properties
		 */
		
		final String path = "src/main/resources/application.properties";
		
//		Properties props = new Properties();
//		try(FileReader reader = new FileReader(path)){
//			props.load(reader);
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
		
		Connection conn = null;
		ResultSet set = null;
		Statement stmt = null;
		
		
//		try{		
//					printPeople();
//		}
//		
//		catch(SQLException e){
//			e.printStackTrace();
//		}
		
		/*
		 * Now that we have a connection, we'd like to execute a 
		 * statement against our DB. So let's do a simple query of
		 * the person table. In order to to execute a statement we
		 * use the statement (or PreparedStatmet) interface, this is
		 * an object representation of a SQL statement
		 */
		try {
			conn = DriverManager.getConnection(
					System.getenv("DB_URL"), 
					System.getenv("DB_username"), 
					System.getenv("DB_password"));
			
		stmt = conn.createStatement();
		
		/*
		 * A ResultSet is a representation of the records that are
		 * returned after executing a query.
		 */
		
		set = stmt.executeQuery("SELECT * FROM person WHERE person_id = 1");
		//Move the cursor to the first record; it should be the only
		//record since person_id is a primary key.
		set.next();
		
		/*
		 * We have to extract the data from each row in a ResultSet
		 * in order to use it
		 */
		Person retrievedPerson = new Person(
				set.getInt(1),
				set.getString(2),
				set.getInt(3),
				set.getString(4),
				set.getString(5)
				);
		
		System.out.println(retrievedPerson.toString());
		
		
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		finally {
			
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
