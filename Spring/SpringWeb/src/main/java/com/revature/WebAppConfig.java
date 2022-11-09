package com.revature;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * Recall that Spring has a built in servlet called the "DispatcherServlet". This
 * class is already included with Spring web, so we only need to take advantage of it.
 * Note that a servlet simply intercepts an HTTP request. In order to map our 
 * DispatcherServlet (e.g. give it a URL/path), we will make our WebAppConfig class
 * implement a built-in interface called the WebApplicationInitializer.
 *
 */
public class WebAppConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//We're going to configure our DispatcherServlet here:
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ApplicationConfig.class);
		ctx.setServletContext(servletContext);
		
		Dynamic servlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(ctx));
		/*
		 * We can tell the framework to create an instance of the DispatcherServlet.
		 * Note that the default behavior for a servlet is to be lazily instantiated.
		 * This method will instruct Spring to eagerly create an instace of the Dispatcher
		 * servlet.
		 */
		servlet.setLoadOnStartup(1);
		/*
		 * Specifying the path that should be used with this servlet. In other words,
		 * this servlet handles requests that are mapped to "/".
		 */
		servlet.addMapping("/");
	}

}
