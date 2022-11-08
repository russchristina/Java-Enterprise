package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.service.PolkamanService;

public class Driver {

	public static void main(String...args) {
		/**
		 * As proof of concept (proving that the IOC container really does have
		 * beans in it), we will pull those beans out of the container. We can use
		 * the application context to do this.
		 * 
		 * Note that ApplicationContext is an interface. It has several implementations.
		 * Some include:
		 * 
		 * - ClassPathXmlApplicationContext (the one we're currently using)
		 * - AnnotationConfigApplicationContext
		 * - FileSystemXmlApplicationContext
		 */
		
		//COMMENTED OUT TO SWITCH TO ANNOTATIONS
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PolkamanService polkamanService = context.getBean("polkamanService", PolkamanService.class);
		
		System.out.println(polkamanService.findAll());
	}
}
