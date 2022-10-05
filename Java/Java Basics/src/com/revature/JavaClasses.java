package com.revature;

/**
 * All things in Java are done within the context of a class. A class serves as a blueprint for
 * objects that will be created later. An object is an instance of a class.
 * 
 * More on blueprinting: A class often represents a real world concept. For instance, if you wish
 * to model a person or an animal or some other "concept", you typically build a class that contains
 * fields (properties) and methods( behaviors).
 * 
 * @author Christina
 *
 */
public class JavaClasses {

	public static void main(String[] args) {
		
		/*
		 * In order to create an instance of a class (to create an object), we use the "new" keyword
		 * with the constructor for the class. In Java, classes actually have default constructors.
		 * That said, you're only using the default constructor when you don't create a constructor
		 * of your own.
		 */
		Person p = new Person("Christina", 28, 66);
		Animal a = new Animal();
		
		Animal a2 = new Person("Name", 89, 90);
		
		p.sleep();
		a2.sleep();
	}
}

/*
 * Java does support inheritance as you can extend other classes, but you can only extend 1 class.
 * In other words, Java doesn't support multiple inheritance.
 * 
 * Also note that all classes in Java have the "Object" class at the top of their family tree.
 */
class Person extends Animal{
	//Object
	private String name; //object types are null by default
	private int age; //primitive types point to default values by default (so this int is "0")
	private int height;
	
	/*
	 * We use constructors to later instantiate objects but often times to initialize fields as 
	 * well. Just by typing this constructor, we are no longer using the default constructor.
	 */
	public Person() {
		super(100);
		//Even though you don't typically type this, the first line of any constructor is a call to the super class's constructor.
		name = "TBD";
		age = -1;
		height = -1;
		//This is inherited from the super class (Animal)
	}
	
	public Person(String name, int age, int height) {
		super(100);
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	
	/*
	 * When you override a method, you cannot change the return type, nor can you make the method's
	 * visibility more restrictive. In other words, if the parent class declared the method as 
	 * "public", you can't make override as a private method.
	 * 
	 * It is a good idea to use the @Override annotation to provide some compile-time safety and
	 * just "document" that you are indeed overriding a method.
	 */
	@Override
	 public void sleep() {
		System.out.println("Zzzzzzzz, check FB, Zzzzzzzzzz");
	}
}
