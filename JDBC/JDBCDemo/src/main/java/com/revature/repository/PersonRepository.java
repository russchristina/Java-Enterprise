package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Person;
import com.revature.util.ConnectionFactory;

/*
 * This class follows what we call the Data Access Object (DAO) design pattern. This design pattern
 * emphasizes separating the concern of data access from other concerns. In essence, we have a dedicated
 * class that handles accessing data.
 */
public class PersonRepository {

	public void save(Person person) {

		PreparedStatement stmt = null;
		final String SQL = "INSERT INTO person values(default, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.getConnection()) {
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, person.getPerson_name());
			stmt.setString(2, person.getPerson_state());
			stmt.setString(3, person.getFavorite_color());
			stmt.setInt(4, person.getAge());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Person> findAll() {

		// Make necessary Objects
		List<Person> persons = new ArrayList<>();
		ResultSet set = null;
		Statement stmt = null;
		Connection conn = null;

		try {

			// Make Connection
			conn = ConnectionFactory.getConnection();

			// Create statement
			stmt = conn.createStatement();

			// Execute Statement
			set = stmt.executeQuery("SELECT * FROM person");

			// Loops through the result set and adds a new person object to the persons list
			// each time
			while (set.next()) {
				persons.add(
						new Person(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5)));
			}
		}

		// Catch whoopsies
		catch (SQLException e) {
			e.printStackTrace();
		}

		// Cleanup
		finally {

			try {
				conn.close();
				set.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return persons;
	}

	public boolean update(Person person) {

		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE person SET person_name = ? , "
				+ "person_state = ?, favorite_color = ?, person_age = ? where person_id = ?";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, person.getPerson_name());
			stmt.setString(2, person.getPerson_state());
			stmt.setString(3, person.getFavorite_color());
			stmt.setInt(4, person.getAge());
			stmt.setInt(5, person.getPerson_id());
			stmt.execute(SQL);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return true;

	}
	
	
	public void deleteById(int id)
    {
		/*
		 * This method uses a PreparedStatement. A PreparedStatement is a special type of Statement
		 * that protects against SQL injection. SQL injection occurs when a user of an application with
		 * malicious intent enters SQL as input, which is then executed against your DB.
		 * 
		 * PreparedStatements are precompiled - this is how they prevent SQL injection as the parameter(s)
		 * is just replaced with the actual value before the query is executed. Parameters are denoted with
		 * the "?" syntax. Each parameter has its own index, starting from 1.
		 */
        String sqlCommand = "DELETE FROM person where person_id = ?";

        try(Connection conn = ConnectionFactory.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(sqlCommand);) {
           
        	stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
