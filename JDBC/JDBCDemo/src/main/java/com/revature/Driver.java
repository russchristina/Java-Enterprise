package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.model.Person;
import com.revature.repository.PersonRepository;

/*
 * While I'm at my meeting:
 * 
 * Group 1: Make a method that allows you to insert a new record into the DB
 * Group 2: Make a method that allows you to find all of the records on a table in the DB
 * Group 3: Make a method that allows you to update a record on table
 * Group 4: Make a method that allows you to delete a record from a table
 * Bonus: Make an abstraction that allows you not to call DriverManager.getConnection every single
 * time you need a connection to your DB.
 */

public class Driver {

	/*
	 * As JDBC provides an interface against which developers must program, the basic types you
	 * encounter are typically interfaces that are built into Java. These include:
	 * 
	 * DriverManager (a class, not an interface)
	 * Connection
	 * Statement
	 * PreparedStatement
	 * ResultSet
	 * SQLException (this is a class)
	 */
	public static void main(String[] args) {
		/*
		 * Let's do a standard JDBC workflow in which we connect to our DB, pull out a single
		 * record, and then close the connection.
		 * 
		 * We'll always need to start by getting a connection to our DB. This entails authenticating
		 * ourselves to a specific DB. The Connection interface represents this connection to a DB.
		 * It is through our connection that we are allowed to execute statements against our DB.
		 * 
		 * We use our DriverManager to obtain a connection. The DriverManager is also responsible
		 * for allowing us to set driver-specific properties.
		 */
		
		/*
		 * If you're using a properties file to read in credentials, the Properties class is a nice
		 * utility for quickly reading properties from a file.
		 */
//		Properties props = new Properties();
//		try(FileReader reader = new FileReader("src/main/resources/application.properties")){
//			props.load(reader);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
		PersonRepository personRepository = new PersonRepository();
		Person p = new Person(6, "Kim', 'IL', 'Green', 50); drop table person; --", "Illinois", "Green", 50);
		personRepository.save(p);
//		personRepository.update(p);
//		personRepository.deleteById(1);
		System.out.println(personRepository.findAll());
		
		Statement stmt = null;
		ResultSet set = null;
		
		final String SQL = "SELECT * FROM person where person_id = 6";
		
		
		/*
		 * Remember to always close your connections. We're using try with resources, so the
		 * connection is automatically closed by Java.
		 */
		try(Connection conn = DriverManager.getConnection(
				System.getenv("url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
			)) {
			
			/*
			 * Now that we have a connection, we'd like to execute a statement against our DB.
			 * So let's do a simple query of the person table. In order to execute a statement,
			 * we use the Statement (or PreparedStatement) interface. This is an object representation
			 * of a SQL statement.
			 */
			
			stmt = conn.createStatement();
			
			/*
			 * A ResultSet is a representation of the records that are returned after executing
			 * query.
			 */
			set = stmt.executeQuery(SQL);
			//Move the cursor to the first record; it should be the only record since person_id is a primary key
			set.next();
			
			/*
			 * We have to extract the data from each row in a ResultSet in order to use it. We
			 * can store all of the information from each column using a Person object.
			 */
			Person retrievedPerson = new Person(
					set.getInt(1),
					set.getString(2),
					set.getString(3),
					set.getString(4),
					set.getInt(5)
					);
			
			System.out.println(retrievedPerson);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
