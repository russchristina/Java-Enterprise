package com.revature;

public class Animal {
	
	private int lifeSpan; //access is "default"
	
	public Animal() {
		
	}
	
	public Animal(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}
	
	public void sleep() {
		System.out.println("Zzzzzzzzzzzzzz");
	}
}
