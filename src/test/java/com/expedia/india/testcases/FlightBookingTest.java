package com.expedia.india.testcases;

import org.testng.annotations.Test;

import com.expedia.india.base.BaseTest;
import com.expedia.india.pages.actions.HomePage;

public class FlightBookingTest extends BaseTest{

	@Test
	public void flightBookingTest() throws InterruptedException {
		HomePage home = new HomePage();
		home.gotoFlights().bookFlight("MAA", "DEL", "06/10/2020", "02/02/2021", "3");
	}

}
