package com.expedia.india.rough;

import com.expedia.india.base.Page;
import com.expedia.india.pages.actions.HomePage;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Page.initConfiguration();
		HomePage home = new HomePage();
		home.gotoFlights().bookFlight("MAA", "DEL", "06/01/2020", "01/01/2021", "3");
	}
}
