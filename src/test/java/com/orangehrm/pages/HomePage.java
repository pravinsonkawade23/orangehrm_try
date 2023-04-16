package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This page contains webelements from home page
 * Rule: create each element name in snake case and give '_' between each word   
 * @author Aniket Khurd
 *
 */

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='panelTrigger']")
	public WebElement logout_dropdown;
	
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logout_link;
	
	@FindBy(xpath = "//h1[text()='Dashboard']")
	public WebElement dashboard_header;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement admin_module_link;
	
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pim_module_link;
	
	@FindBy(xpath = " //a[@id='menu_dashboard_index']")
	public WebElement dashboard_link;
}
