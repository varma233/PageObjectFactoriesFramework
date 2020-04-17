package com.expedia.india.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	public static void selectDate(WebElement element, String date) {
		element.click();
		String[] selectedDate = date.trim().split("/");
		int mm = Integer.parseInt(selectedDate[0]) - 1;
		int dd = Integer.parseInt(selectedDate[1]);
		int yyyy = Integer.parseInt(selectedDate[2]);

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		while (!isDateFound(mm, dd, yyyy)) {
			WebElement we = driver.findElement(By.xpath(
					"//div[@class='datepicker-dropdown']//button[contains(@class,'datepicker-paging datepicker-next btn-paging btn-secondary next')]"));
			if (we.isDisplayed())
				we.click();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	}

	private static boolean isDateFound(int mm, int dd, int yyyy) {
		List<WebElement> matchDates = driver
				.findElements(By.xpath("//div[@class='datepicker-dropdown']//button[@data-day=\'" + dd
						+ "\'][@data-month=\'" + mm + "\'][@data-year=\'" + yyyy + "\']"));
		if (matchDates.size() == 0)
			return false;
		else
			matchDates.get(0).click();
		return true;
	}

	public static void selectTravellers(WebElement element, String value, String type) {
		element.click();
		List<WebElement> plusButtons = driver.findElements(By.xpath(
				"//div[contains(@class,'traveler-selector-sinlge-room-data traveler-selector-room-data')]//button[@class='uitk-step-input-button uitk-step-input-plus']"));

		int travelers = Integer.parseInt(value);
		if (plusButtons.size() > 0) {
			switch (type.trim().toUpperCase()) {

			case "CHILDREN":
				for (int i = 0; i < travelers; i++)
					plusButtons.get(1).click();
				break;
			case "INFANTS":
				for (int i = 0; i < travelers; i++)
					plusButtons.get(2).click();
				break;
			default:
				for (int i = 1; i < travelers; i++)
					plusButtons.get(0).click();
			}
		} else {
			System.out.println("Not able to find increment buttons");
		}

	}

}
