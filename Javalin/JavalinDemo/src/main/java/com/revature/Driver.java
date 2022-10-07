package com.revature;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.model.Person;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Driver {
	
	public static void main(String[] args) {
		
		/*
		 * Javalin is considered lightweight framework for quickly building RESTful APIs.
		 * It comes with an embedded Jetty server and is an abstraction over an older
		 * technology called servlets.
		 */
		
		//Starts our server on port 8000
		Javalin app = Javalin.create().start(8000);
		
		/*
		 * As a matter of abstraction, sometimes we wish to perform a task before
		 * an HTTP Request makes it to its destination. In order to avoid mixing this
		 * logic into all of our endpoint logic, we can use an interceptor.
		 */
		
		app.before(ctx -> {
			System.out.println("This happens before the http requests make it to their final destination.");
		});
		
		/*
		 * Javalin uses lambda expressions heavily. It primarily uses the Handler
		 * interface. This interface has a single abstract method called handle that
		 * takes a Context object and has a void return type.
		 * 
		 * As a note, the Context is an abstraction over servlet internals that allow
		 * us to access and manipulate the HTTP request and HTTP response as Java objects.
		 */
		
		app.get("/person/{id}", (Context ctx) -> {
			/*
			 * You can also take a Java object and serialize it as JSON before writing it
			 * to the response body.
			 */
			Set<Person> people = new HashSet<>();
			Person person = new Person(1, "Sean", 23);
			Person person2 = new Person(2, "Zeke", 22);
			Person person3 = new Person(3, "Jen", 25);
			
			people.add(person);
			people.add(person2);
			people.add(person3);
			
			Person selectedPerson = null;
			
			for(Person p : people) {
				if(p.getId() == Integer.parseInt(ctx.pathParam("id"))) selectedPerson = p;
			}
			
			
			ctx.json(selectedPerson);
		});
		
		app.post("/new-item", ctx -> {
			/*
			 * If a client is making a POST request, this means that there must be something
			 * in the HTTP request body that we can extract.
			 * 
			 * Note that we can extract the body as a String, or we can immediately marshal
			 * the body into a Java object.
			 */
			Person receivedPerson = ctx.bodyAsClass(Person.class);
			System.out.println(receivedPerson);
			ctx.status(HttpStatus.CREATED_201);
			
		});
	}

}
