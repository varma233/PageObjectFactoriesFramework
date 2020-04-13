package com.expedia.india.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators{  

	// TABS
	@FindBy(css = "#tab-flight-tab-hp")
	public WebElement flightsTab;
	
	@FindBy(css = "#tab-hotel-tab-hp")
	public WebElement hotelsTab;
	
	@FindBy(css = "#tab-package-tab-hp")
	public WebElement flightsAndHotelsTab;
	
	@FindBy(css = "#tab-car-tab-hp")
	public WebElement carHireTab;
	
	@FindBy(css = "#tab-activity-tab-hp")
	public WebElement holidayActiviesTab;
	
	
	// FLIGHT BOOKING
	@FindBy(xpath = "//input[@id='flight-origin-hp-flight']")
	public WebElement flyingfrom;
	
	@FindBy(xpath = "//input[@id='flight-destination-hp-flight']")
	public WebElement goingto;
	
	@FindBy(xpath = "//input[@id='flight-departing-hp-flight']")
	public WebElement departing;

	@FindBy(xpath = "//input[@id='flight-returning-hp-flight']")
	public WebElement returning;

	@FindBy(xpath = "//div[@id='traveler-selector-hp-flight']//button[contains(@class,'trigger-utility menu-trigger btn-utility btn-secondary dropdown-toggle theme-standard pin-left menu-arrow gcw-component gcw-traveler-amount-select gcw-component-initialized')]")
	public WebElement travellers;

	@FindBy(xpath = "//form[@id='gcw-flights-form-hp-flight']//button[contains(@class,'btn-primary btn-action gcw-submit')]")
	public WebElement searchFlights;

}
