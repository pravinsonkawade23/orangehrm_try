package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This page contains webelements from login page
 * Rule: create each element name in snake case and give '_' between each word   
 * @author Aniket Khurd
 *
 */
public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "txtUsername")
	public WebElement username_field;
	
	@FindBy(id = "txtPassword")
	public WebElement password_field;
	
	@FindBy(id = "btnLogin")
	public WebElement login_button;
	
	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement invalid_credentials_message;
}
