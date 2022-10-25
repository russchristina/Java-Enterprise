package com.revature;

import java.security.Key;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.model.Person;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpSession;

public class Driver {

	public static void main(String[] args) {
		
		// The key I'll use to sign the JWT I create later.
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

		/*
		 * Javalin is considered lightweight framework for quickly building RESTful
		 * APIs. It comes with an embedded Jetty server and is an abstraction over an
		 * older technology called servlets.
		 */

		// Starts our server on port 8000
		Javalin app = Javalin.create().start(8000);

		/*
		 * As a matter of abstraction, sometimes we wish to perform a task before an
		 * HTTP Request makes it to its destination. In order to avoid mixing this logic
		 * into all of our endpoint logic, we can use an interceptor.
		 */

		app.before(ctx -> {
			System.out.println("This happens before the http requests make it to their final destination.");
		});

		/*
		 * Javalin uses lambda expressions heavily. It primarily uses the Handler
		 * interface. This interface has a single abstract method called handle that
		 * takes a Context object and has a void return type.
		 * 
		 * As a note, the Context is an abstraction over servlet internals that allow us
		 * to access and manipulate the HTTP request and HTTP response as Java objects.
		 */

		app.post("/login", ctx -> {

			/*
			 * This resource takes in user credentials and authenticates the client if the
			 * credentials are correct. If the user credentials are correct, I will grant
			 * them a session. Some of my options for session handling include:
			 * 
			 * 1) Cookies: A cookie is actually stored on the client machine as a file.
			 * Every single time a client makes a request to a domain, the cookies
			 * associated with that domain come with the request. We can create a cookie on
			 * the server side and send it to the client. Note also that a cookie is a
			 * key-value pair.
			 * 
			 * 2) HttpSession: Technically, HttpSessions in Java do store a cookie on the
			 * client machine. That said, they also store information on the server side.
			 * This information is an ID that is associated with a session. Every time the
			 * client sends its cookies, the JSessionID is checked against the id for the
			 * one of the cookies. This method of session handling is easy, but if you use
			 * it, your API is not truly RESTful in that you're storing information about
			 * the session on the server itself.
			 * 
			 * 3) JSON web tokens (JWTs): A JSON web token is another option for handling sessions.
			 * A JSON web token is a more RESTful option as it doesn't require that you store
			 * session information on the server, which makes your application stateless.
			 * JSON web tokens are passed to the server from the client on every HTTP request.
			 * The token is initially given to the client by the server. The tokens themselves
			 * are actually encrypted and usually signed by the server. If the token is at all
			 * tampered with, most libraries will warn you so that you can choose not to acknowledge
			 * the token. Note that this requires a 3rd party library, and there MANY providers.
			 * 
			 * NOTE: For this example, I will assume that the correct credentials must be
			 * "Christina" for the username and "pass" for the password.
			 */

			// COMMENTED OUT TO SHOW HTTPSESSIONS

//			Cookie myCookie = new Cookie("authenticated", "true");
//			/*
//			 * If you set a cookie to HttpOnly, you can't use JS on the client side
//			 * to access the underlying cookie's value.
//			 */
//			myCookie.setHttpOnly(true);
//			ctx.res().addCookie(myCookie);

			//COMMENTED OUT IN FAVOR OF JSON WEB TOKENS
//			HttpSession session = ctx.req().getSession();
//
//			/*
//			 * Using an HttpSession grants you the ability to create session attributes.
//			 * Note that these attributes are stored on the server.
//			 */
//			session.setAttribute("role", "manager");
			
			/*
			 * Let's start by creating our JWT. We're actually going to create a
			 * signed JWT (JWS). When we use a JWS, we at least know that the signature
			 * attached to the JWT guarantees the validity of the sender. It also
			 * ensures that no one manipulates or changes the token after it has been
			 * created. Note that you can add "claims" to your JWTs. Claims are just a
			 * JWT's body and are the info the creator of the JWT wants to present to
			 * a recipient.
			 */
			
			String jws = Jwts.builder()
					.setSubject("auth")
					.claim("message", "what's up")
					.signWith(key)
					.compact();
			
			ctx.cookie("jwt", jws);

		});

		app.get("/logout", ctx -> {

			/*
			 * When you wish to end a session when using cookies, you must indicate that you
			 * want the cookie to expire. Since all of the cookies come with the client
			 * request, you can grab the array of cookies and look for the specific cookie
			 * you want to make expire.
			 */

//			Cookie[] cookies = ctx.req().getCookies();
//			
//			for(Cookie cookie : cookies) {
//				if(cookie.getName().equals("authenticated")) cookie.setValue("false");
//			}

			/*
			 * To get rid of an HttpSession:
			 */

			HttpSession session = ctx.req().getSession(false);
			if (session != null)
				session.invalidate();
		});

		app.get("/person/{id}", (Context ctx) -> {

//			//Doing a cookie check:
//			Cookie[] cookies = ctx.req().getCookies();
//			if(cookies == null) {
//				ctx.json("not authenticated!");
//			}

			// Check for an HttpSession instead:
//			HttpSession session = ctx.req().getSession(false);
//			if (session == null) {
//				ctx.json("not authenticated");
//			} 
			
			//To check the token that the client has passed you. If this can't be parsed
			//properly for some reason, an exception will be thrown.
			Jws<Claims> jwsClaims = Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(ctx.cookie("jwt"));
			
			if(jwsClaims.getBody() != null) {
				//TBD
			}
			
		else {

				/*
				 * Note that authentication and authorization should be differentiated.
				 * Authentication is used to determine the client's identity. Authorization,
				 * on the other hand, is not about verifying a client's identity. It is instead
				 * about verifying the client's privileges. 
				 */
//				if (session.getAttribute("role").equals("manager")) {
					/*
					 * You can also take a Java object and serialize it as JSON before writing it to
					 * the response body.
					 */
					Set<Person> people = new HashSet<>();
					Person person = new Person(1, "Sean", 23);
					Person person2 = new Person(2, "Zeke", 22);
					Person person3 = new Person(3, "Jen", 25);

					people.add(person);
					people.add(person2);
					people.add(person3);

					Person selectedPerson = null;

					for (Person p : people) {
						if (p.getId() == Integer.parseInt(ctx.pathParam("id")))
							selectedPerson = p;
					}

					ctx.json(selectedPerson);
				}
//			}

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
