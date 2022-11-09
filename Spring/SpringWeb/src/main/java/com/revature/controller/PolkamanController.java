package com.revature.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Polkaman;

/**
 * 
 * Recall that we encountered several Spring stereotypes yesterday. Today, we will
 * see two more: @Controller and @RestController. These stereotypes are used to denote
 * that a class will map resources that will be exposed to a client.
 * 
 * Note that @Controller does NOT imply that you're exposing RESTful resources. This is
 * because @Controller is used for internal resource view resolving, meaning that if you
 * had views hosted on a server on the backend, you could use a use a controller to serve
 * those views to the client. You won't need this functionality because you know a 
 * frontend framework. As such, you don't need a simple controller. You need a @RestController.
 * 
 * A @RestController assumes that your methods on this class will write to the HTTP response
 * body. That is to say, whatever your methods on this class return will be written
 * to the HTTP response body (as JSON by default).
 *
 */
@RestController("polkamanController")
/*
 * Of course, we need URIs for our resources; there has to be some way for the client to
 * know how to uniquely identify resources on the server just like we had with Javalin.
 * We can do the same with Spring using the @RequestMapping annotation.
 * 
 * This entire controller is mapped to "/polkaman" and we will expose subresources under
 * "/polkaman".
 */
@RequestMapping(path = "/polkaman")
public class PolkamanController {

	/*
	 * This method defines a subresource. In order to access this resource, the client
	 * should use the path "http://localhost:8080/ProjectName/polkaman/hello".
	 */
	@RequestMapping(path = "/hello", method = {RequestMethod.GET})
	public String sayHello() {
		return "Hello, World!";
	}
	
}
