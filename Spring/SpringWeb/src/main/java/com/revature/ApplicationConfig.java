package com.revature;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * This is a class-based (largely driven by annotations) approach to configuring my
 * ApplicationContext.
 * 
 * When you start using an annotation-driven approach, you must tell Spring where to
 * look (which packages to scan) to find the annotations using the @ComponentScan
 * annotation.
 * 
 * NOTE: If you have a class that has @Bean methods, the class should be marked as a
 * @Configuration class.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.revature"})
public class ApplicationConfig /*extends WebMvcConfigurationSupport*/ {

	/*
	 * The default message converter did not work with my class-based configuration
	 * because I had forgotten to use the @EnableWebMvc annotation to enable built-in
	 * features of Spring web such as default message converters, so I added the 
	 * Jackson message converter as a bean myself. Also, I will keep this here as
	 * you sometimes may want to add your own message converters.
	 */
	
//	@Override
//	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(converter());
//		addDefaultHttpMessageConverters(converters);
//	}
//	
//	@Bean
//	public MappingJackson2HttpMessageConverter converter() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		return converter;
//	}
	
	/*
	 * We can add beans to the IOC container using a class-based configuration by
	 * creating methods that are annotated with @Bean. Note that @Bean is not preferred
	 * for really simple bean definitions; it is typically with highly customizable
	 * beans that you need to configure before handing those beans off to the IOC
	 * container.
	 * 
	 * NOTE: You can use the "name" attribute to name a bean OR you can use the method
	 * name as the bean name.
	 */
//	@Bean(name = "polkamanService")
//	@Scope("singleton")
//	public PolkamanService getPolkamanService() {
//		PolkamanService polkamanService = new PolkamanService();
//		polkamanService.setPolkamanRepository(getPolkamanRepository());
//		return polkamanService;
//	}
//	
//	@Bean(name = "polkamanRepository")
//	public PolkamanRepository getPolkamanRepository() {
//		return new PolkamanRepository();
//	}
}
