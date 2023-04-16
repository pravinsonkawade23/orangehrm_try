package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
	WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "btnAdd")
	public WebElement add_new_employee_button;
	
	public By add_new_employee_button_1 = By.id( "btnAdd");
	
	@FindBy(xpath = "//h1[text()='Add Employee']")
	public WebElement add_employee_header;

	@FindBy(id = "firstName")
	public WebElement first_name_field;

	@FindBy(id = "lastName")
	public WebElement last_name_field;

	@FindBy(id = "employeeId")
	public WebElement employee_id_field;

	@FindBy(xpath = "//label[text()='Create Login Details']/following-sibling::input[@id='chkLogin']")
	public WebElement create_login_checkbox;

	@FindBy(id = "user_name")
	public WebElement employee_username_field;

	@FindBy(id = "user_password")
	public WebElement employee_password_field;

	@FindBy(id = "re_password")
	public WebElement confirm_password;

	@FindBy(id = "status")
	public WebElement select_status_dropdown;

	@FindBy(xpath = "//h1[text()='Personal Details']")
	public WebElement personal_details_header;

	@FindBy(xpath = "//input[ @id='btnSave' and @value='Edit']")
	public WebElement edit_personal_details_button;

	@FindBy(xpath = "//select[@id='personal_cmbMarital']")
	public WebElement marital_status_dropdown;

	public WebElement select_gender(String gender) {
		WebElement element = driver
				.findElement(By.xpath("//label[text()='" + gender + "']/preceding-sibling::input[@type='radio']"));
		return element;
	}
	
	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	public WebElement nationality_dropdown;
	
	@FindBy(id = "btnSave")
	public WebElement save_button;
	
	@FindBy(xpath = " //*[@id=\"pdMainContainer\"]/div[2]/div")
	public WebElement successful_message;
}
