package com.revature.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Polkaman;
import com.revature.service.PolkamanService;

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
/*
 * If you are trying to hit these endpoints from a different origin (e.g. from an
 * Angular application), you can use the @CrossOrigin annotation to specify that you
 * want this application to accept requests from different origins.
 */
@CrossOrigin(origins = {"http://localhost:4200"})
public class PolkamanController {

	//Tell Spring to inject the Polkaman service bean from the container into the
	//polkamanController bean.
	@Autowired
	private PolkamanService polkamanService;
	/*
	 * We're wiring in the RestTemplate bean that has been added to the IOC container.
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * This method defines a subresource. In order to access this resource, the client
	 * should use the path "http://localhost:8080/ProjectName/polkaman/hello".
	 */
	@RequestMapping(path = "/hello", method = {RequestMethod.GET})
	public String sayHello() {
		return "Hello, World!";
	}
	
	/*
	 * @GetMapping is a specialization of @RequestMapping that assumes the HTTP verb is GET.
	 * 
	 * Note that besides the path attribute, there are other useful attributes. If you have
	 * an endpoint that writes to the response body, you will want to use the "produces"
	 * attribute to specify what the content type that is written to the response body is.
	 * Another useful attribute is the "consumes" attribute. This is used when you have an
	 * endpoint that accepts data from the client but you're only willing to accept a certain
	 * format for that data.
	 */
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Polkaman> findAll(){
		/*
		 * The return value for a method is serialized as JSON.
		 */
		return this.polkamanService.findAll();
	}
	
	/*
	 * This method will accept a Polkaman as JSON from the client. We can easily
	 * take JSON from the request body and immediately store it as a Polkaman object
	 * in our Java application by using the @RequestBody annotation.
	 */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Polkaman polkaman) {
		System.out.println(polkaman);
	}
	
	/*
	 * This method will accept a GET request. It will return a single Polkaman based
	 * on the id that is supplied by the client. The id will be supplied as a part of
	 * the URL (e.g. http://localhost:8080/SpringWeb/polkaman/1).
	 * 
	 * In order to specify that a method parameter should be bound to a path variable,
	 * we can use the @PathVariable annotation before that parameter.
	 * 
	 * In this example, we are using a ResponseEntity. This is a bit more elegant in that
	 * it allows us to populate the response body while also specifying a specific HTTP
	 * status code.
	 */
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Polkaman> findOne(@PathVariable int id) {
		return ResponseEntity.of(this.polkamanService.findOne(id));
	}
	
	/*
	 * We can also easily grab query parameters from query strings using the @RequestParam
	 * annotation. Note that the parameter names that we use in the method will be used
	 * as the request parameter names by default, but this can be changed by using the
	 * "name" attribute for the @RequestParam.
	 */
	@GetMapping(path = "/between")
	public ResponseEntity<List<Polkaman>> findAllBetween(@RequestParam int id1, @RequestParam int id2, 
			@RequestParam(required = false) String sort){
		
		List<Polkaman> polkamans = this.polkamanService.findAllBetween(id1, id2);
		HttpStatus status = (polkamans.isEmpty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<>(polkamans, status);
	}
	
	/*
	 * We will make an endpoint that allows our clients to make a request for a polkaman
	 * from the Pokeapi. Our API will then make an HTTP request to the Pokeapi and
	 * send the client the polkaman in response. In order to make an HTTP request
	 * from our backend, we will have to use a RestTemplate.
	 */
	
	@GetMapping(path = "/pokeapi/{name}")
	public Object findPolkamanFromThirdPartyApi(@PathVariable String name) {
		//Come back and revise for URI later
		/*
		 * For this example, we don't have a DTO. That said, if you need one, feel free to make one
		 * and replace the second argument. Instead of Object.class, you will want to use your DTO's
		 * type.
		 */
		return this.restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Object.class);
	}
	
	
	
}
