package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloTest {
	
	private Driver driver;
	
	@Test
	public void testSayHello() {
		driver = new Driver();
		
		Assertions.assertEquals("Hello World", driver.sayHello());
	
	}
}
