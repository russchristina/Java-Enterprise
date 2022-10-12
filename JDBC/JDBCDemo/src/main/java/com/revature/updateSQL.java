package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateSQL {
	
	public static void main(String [] args) {

	String sqlQ = "INSERT INTO employee VALUES (default, 'Sam', 'California', 22)";
	updateSQL uDB = new updateSQL();
	uDB.addToDB(sqlQ);
	}
	public void addToDB (String sqlQ) {
		
		Statement stmt = null;

		try (Connection conn = DriverManager.getConnection(
					System.getenv("url"), 
					System.getenv("db_username"), 
					System.getenv("db_password")
					)) {
			
			 stmt = conn.createStatement();
			 
				try {
					stmt.executeUpdate(sqlQ);
				} catch (SQLException e) {
					e.printStackTrace();
				}
 
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	}
}//End of Class
