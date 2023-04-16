package com.orangehrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
		
	public UserManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "btnAdd")
	public WebElement add_new_user_button;
	
	@FindBy(xpath = "//a[contains(text(),'>')]")
	public WebElement system_users_header;
	
	@FindBy(xpath = "//h1[text()='Add User']")
	public WebElement add_user_header;
	
	@FindBy(id = "systemUser_userType")
	public WebElement user_role_dropdown;
	
	@FindBy(id = "systemUser_employeeName_empName")
	public WebElement employee_name_field;
	
	@FindBy(id = "systemUser_userName")
	public WebElement new_username_field;
	
	@FindBy(id = "systemUser_status")
	public WebElement status_dropdown;
	
	@FindBy(id = "systemUser_password")
	public WebElement new_user_password_field;
	
	@FindBy(id = "systemUser_confirmPassword")
	public WebElement confirm_password_field;
	
	@FindBy(id = "btnSave")
	public WebElement save_button;
}
