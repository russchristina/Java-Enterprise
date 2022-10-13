package com.revature.model;

public class Person {

	private int person_id;
	private String person_name;
	private String person_state;
	private String favorite_color;
	private int age;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int person_id, String person_name, String person_state, String favorite_color, int age) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
		this.person_state = person_state;
		this.favorite_color = favorite_color;
		this.age = age;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getPerson_state() {
		return person_state;
	}

	public void setPerson_state(String person_state) {
		this.person_state = person_state;
	}

	public String getFavorite_color() {
		return favorite_color;
	}

	public void setFavorite_color(String favorite_color) {
		this.favorite_color = favorite_color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((favorite_color == null) ? 0 : favorite_color.hashCode());
		result = prime * result + person_id;
		result = prime * result + ((person_name == null) ? 0 : person_name.hashCode());
		result = prime * result + ((person_state == null) ? 0 : person_state.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (favorite_color == null) {
			if (other.favorite_color != null)
				return false;
		} else if (!favorite_color.equals(other.favorite_color))
			return false;
		if (person_id != other.person_id)
			return false;
		if (person_name == null) {
			if (other.person_name != null)
				return false;
		} else if (!person_name.equals(other.person_name))
			return false;
		if (person_state == null) {
			if (other.person_state != null)
				return false;
		} else if (!person_state.equals(other.person_state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_state=" + person_state
				+ ", favorite_color=" + favorite_color + ", age=" + age + "]";
	}

}
