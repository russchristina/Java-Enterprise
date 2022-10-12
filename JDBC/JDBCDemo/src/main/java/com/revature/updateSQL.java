package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateSQL {

	String def;
	String name;
	String state;
	int age;
	
	public void addToDB (String def, String name, String state, int age) {
		this.def = "default";
		this.name = name;
		this.state = state;
		this.age = age;
		
		Statement stmt = null;

		try (Connection conn = DriverManager.getConnection(
					System.getenv("url"), 
					System.getenv("db_username"), 
					System.getenv("db_password")
					)) {
			
			 stmt = conn.createStatement();
			 String sql = "INSERT INTO employee VALUES ("+ def +", '" + name + "', '" + state + "', " + age +")";
				try {
					stmt.executeUpdate(sql);
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
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
