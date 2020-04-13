package com.expedia.india.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	@BeforeTest
	public void InitalizePage(){
		Page.initConfiguration();
	}
	
	@AfterTest
	public void quitBrowser() {
		Page.quitBrowser();
	}

}
