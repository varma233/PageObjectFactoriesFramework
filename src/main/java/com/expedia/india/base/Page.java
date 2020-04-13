package com.expedia.india.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.expedia.india.utilities.ExtentManger;

public class Page {  

	public static WebDriver driver;
	public static String rootDirectory = System.getProperty("user.dir");

	public static ExtentReports extent = ExtentManger.getInstance();
	public static ExtentTest test;

	public static void initConfiguration() { 
		switch (Constants.browser.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					rootDirectory + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "FIREFOX":
			System.getProperty("webdriver.gecko.driver",
					rootDirectory + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(Constants.baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public static void quitBrowser() {
		driver.quit();
	}

}
