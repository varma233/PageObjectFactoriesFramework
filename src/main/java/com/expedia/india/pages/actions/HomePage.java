package com.expedia.india.pages.actions;

import org.openqa.selenium.support.PageFactory;

import com.expedia.india.base.Page;
import com.expedia.india.pages.locators.HomePageLocators;

public class HomePage extends Page{
	
	public HomePageLocators home;  
	
	public HomePage() {
		this.home = new HomePageLocators();
		PageFactory.initElements(driver, this.home);
	}
	
	public HomePage gotoFlights() {
		home.flightsTab.click();
		return this;
	}
	
	public HomePage gotoHotels() {
		home.hotelsTab.click();
		return this;

	}
	
	public HomePage gotoFlightsAndHotels() {
		home.flightsAndHotelsTab.click();
		return this;
	}
	
	public HomePage gotoCarHire() { 
		home.carHireTab.click();
		return this;
	}
	
	public HomePage gotoHolidayActivities() {
		home.holidayActiviesTab.click();
		return this;
	}
	
	public void bookFlight(String flyingFrom, String goingTo, String Departing, String Returning, String Travellers) throws InterruptedException{
		home.flyingfrom.sendKeys(flyingFrom);
		home.goingto.sendKeys(goingTo);
		home.departing.sendKeys(Departing);
		home.returning.clear();
		home.returning.sendKeys(Returning);
		home.travellers.sendKeys(Travellers);
		Thread.sleep(2000);
		home.searchFlights.click();
	}

}
