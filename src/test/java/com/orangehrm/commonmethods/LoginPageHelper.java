package com.orangehrm.commonmethods;

import org.openqa.selenium.WebDriver;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.ConfigurationReader;

/**
 * This page contains required methods for login page
 * @author Aniket Khurd
 *
 */
public class LoginPageHelper {
	public WebDriver driver;
	LoginPage loginPage;
	
	public LoginPageHelper(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(driver);
	}
	
	public void login() {
		loginPage.username_field.clear();
		System.out.println("______Entering username_____");
		System.out.println("username: "+ConfigurationReader.getProperty("username"));
		loginPage.username_field.sendKeys(ConfigurationReader.getProperty("username"));
		System.out.println("______Entering password_____");
		loginPage.password_field.clear();
		loginPage.password_field.sendKeys(ConfigurationReader.getProperty("password"));
		loginPage.login_button.click();
	}
}
