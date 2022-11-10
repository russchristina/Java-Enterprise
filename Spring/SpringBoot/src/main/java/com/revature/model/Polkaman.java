package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Recall that JPA (Java Persistence API) is an interface provided by Java. This interface
 * allows some abstraction of our data access.
 * 
 * One feature provided by JPA is annotations that allow us to map a Java class to an
 * entity (table) in a database. When using JPA, you can even tell JPA to generate 
 * tables for you based on your Java models. That said, this is not good practice as
 * you should be writing your own SQL scripts for table generation.
 */

/*
 * This annotation marks this class as an entity, meaning that it will be added the JPA's
 * persistence context.
 */
@Entity
/*
 * The Table annotation allows us to associate our entity with a table in our DB.
 * Note that the default name for the table that is generated will be the class name
 * if no other name is specified ("Polkaman" in this case).
 */
@Table(name = "polkaman")
public class Polkaman {
	
	//Add another model to show a few more JPA annotations tomorrow.

	/*
	 * This annotation specifies that a field is a primary key for a table.
	 */
	@Id
	/*
	 * This annotation denotes that a field corresponds to a column on the table.
	 * You can even add constraints here.
	 */
	@Column(name = "polkaman_id")
	/*
	 * If your primary key is an auto-incrementing type, you'll also want to add two additional
	 * annotations here.
	 */
	@GeneratedValue(generator = "polkaman_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "polkaman_id_seq")
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String type;

	public Polkaman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Polkaman(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polkaman other = (Polkaman) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Polkaman [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
