package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 * A Spring Boot application is a completely functional project with pre-configured
 * Spring modules with reasonable defaults; we can this an opinionated project
 * configuration. Yes, you can change the defaults if you need to.
 * 
 * @SpringBootApplication is a convenience annotation that is a combination of several
 * different annotations:
 * 
 * @ComponentScan (it tells Spring which packages to scan for annotations)
 * @EnableAutoConfiguration (allows bootstrapping of basic beans)
 * @Configuration (allows you to create methods annotated with @Bean in this class)
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
