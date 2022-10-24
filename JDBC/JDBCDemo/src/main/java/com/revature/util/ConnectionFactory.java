package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/*
	 * This is a utility that allows us to abstract out using the DriverManager to get a connection
	 * to our DB. This class follows a "Factory" design pattern. A factory produces instances (usually
	 * customizable with pre-configured properties) to the caller.
	 */
	public static Connection getConnection() throws SQLException{

		Connection conn = DriverManager.getConnection(
				System.getenv("url"), 
				System.getenv("db_username"),
				System.getenv("db_password"));
		
		//If you want all of your connection instances to NOT use autocommit:
//		conn.setAutoCommit(false);
		
		return conn;

	}
}
