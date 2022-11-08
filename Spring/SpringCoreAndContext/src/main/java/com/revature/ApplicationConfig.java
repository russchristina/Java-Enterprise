package com.revature;

import org.springframework.context.annotation.ComponentScan;

/*
 * This is a class-based (largely driven by annotations) approach to configuring my
 * ApplicationContext.
 * 
 * When you start using an annotation-driven approach, you must tell Spring where to
 * look (which packages to scan) to find the annotations using the @ComponentScan
 * annotation.
 */
@ComponentScan(basePackages = {"com.revature"})
public class ApplicationConfig {

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
