package com.revature;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
		Properties props = new Properties();
		try(FileReader reader = new FileReader("src/main/resources/application.properties")){
			props.load(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		try {
		conn = DriverManager.getConnection(
				props.getProperty("url"), 
				props.getProperty("username"), 
				props.getProperty("password")
			);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
