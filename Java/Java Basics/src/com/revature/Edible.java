package com.revature;

/**
 * If you recall, Java does not support multiple inheritance. It is only possible for a class to
 * directly extend one other class.
 * 
 * Interfaces are abstract types. An abstract type can contain abstract methods. An abstract method
 * is a method that does not have a implementation. Note that it is not possible to create an instance
 * of an abstract type. As such, abstract types are largely used to allow classes to inherit methods
 * and fields from them.
 * 
 * Some common interface you might see frequently or might find useful include:
 * 
 * Serializable (example of a marker interface)
 * Comparable (used to establish a natural order for a custom type)
 * Comparator (similar to Comparable, but it is external to the class)
 * Collection
 * List
 * Set
 * Queue
 * Map
 * 
 * @author Christina
 *
 */
public interface Edible {
	
	/*
	 * If you have a field on an interface, it must be public, static, and final.
	 * As a note, the "final" modifier used with a variable indicates that the variable can
	 * never be reassigned; it must always point to the same value or object in memory.
	 */
	public static final int edibleNum = 0;

	/*
	 * Methods on interfaces are assumed to be public and abstract.
	 */
	void beNotPoisonous();
	
	/*
	 * Sometimes we want to provide a default implementation that can be inherited.
	 * 
	 * You can achieve this in 2 ways:
	 * 
	 * 1) Use the "default" keyword
	 * 2) Use the "static" keyword
	 */
	default void provideMacros() {
		System.out.println("I provide essential macronutrients");
	}
	
	static void provideMicros() {
		System.out.println("I provide essential vitamins and minerals, both water soluble and fat soluble");
	}
	
}

/*
 * Yes, other interfaces can extend interfaces. Because an interface is an abstract type, it is NOT
 * required to provide implementations for any abstract methods it inherits.
 */
interface NonToxic extends Edible{
	
	/*
	 * Yes, a child interface can redeclare a method that had an implementation, making it 
	 * abstract.
	 */
	void provideMacros();
}


