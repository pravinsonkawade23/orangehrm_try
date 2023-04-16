package com.orangehrm.commonmethods;

import org.openqa.selenium.WebDriver;

import com.orangehrm.pages.HomePage;
import com.orangehrm.utilities.CommonUtils;

public class HomePageHelper {
	WebDriver driver;
	HomePage homePage;
	CommonUtils commonUtils;
	
	public HomePageHelper(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(driver);
		commonUtils = new CommonUtils(driver);
	}
	
	public void logOut() {
		homePage.logout_dropdown.click();
		commonUtils.watForVisibility(homePage.logout_link, 10);
		homePage.logout_link.click();
	}
}
