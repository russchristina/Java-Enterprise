package com.revature;

/*
 * You can create abstract classes as well. The assumption about an abstract class is that it's not
 * entirely abstract. As such, an abstract class is a class that CAN have abstract methods; this does
 * not mean it has any abstract methods. Since an abstract class is an abstract type, you cannot
 * instantiate the type.
 */
public abstract class Animal {
	
	private int lifeSpan; //access is "default"
	
	public Animal() {
		
	}
	
	public Animal(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}
	
	public void sleep() {
		System.out.println("Zzzzzzzzzzzzzz");
	}
	
	/*
	 * If you want an abstract method, you have to be deliberate about it on an abstract class.
	 */
	public abstract void breathe();
}
