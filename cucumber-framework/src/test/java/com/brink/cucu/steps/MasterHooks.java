package com.brink.cucu.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.DriverFactory;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() {
		System.out.println("@Before setup(): initializing driver");
		getDriver();
	}
	
	@After
	public void tearDown() {
		System.out.println("@After tearDown(): closing driver");
		if(driver != null) {
			driver.manage().deleteAllCookies();
			driver.close();
		}
	}
}
