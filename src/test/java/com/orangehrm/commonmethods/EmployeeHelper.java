package com.orangehrm.commonmethods;

import org.openqa.selenium.WebDriver;

import com.orangehrm.pages.EmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.utilities.CommonUtils;

public class EmployeeHelper {
	WebDriver driver;
	EmployeePage employeePage;
	HomePage homePage;
	CommonUtils commonUtils;
	
	
	public EmployeeHelper(WebDriver driver) {
		this.driver = driver;
		employeePage = new EmployeePage(driver);
		homePage = new HomePage(driver);
		commonUtils = new CommonUtils(driver);
	}
	
	public void addNewEmployeeAndCreateLogin(String firstName, String lastName, int employeeId, String username, String password, String status, String gender, String maritalStatus, String nationality) 
	{
		homePage.pim_module_link.click();
		commonUtils.watForVisibility(employeePage.add_new_employee_button, 20);
		employeePage.add_new_employee_button.click();
		commonUtils.watForVisibility(employeePage.add_employee_header, 20);
		System.out.println("******Adding new employee details******");
		employeePage.first_name_field.sendKeys(firstName);
		employeePage.last_name_field.sendKeys(lastName);
		employeePage.employee_id_field.clear();
		employeePage.employee_id_field.sendKeys(String.valueOf(employeeId));
		employeePage.create_login_checkbox.click();
		System.out.println("******Creating login for new employee******");
		employeePage.employee_username_field.sendKeys(username);
		employeePage.employee_password_field.sendKeys(password);
		employeePage.confirm_password.sendKeys(password);
		commonUtils.selectValueFromDropDown(employeePage.select_status_dropdown, status);
		employeePage.save_button.click();
		commonUtils.watForVisibility(employeePage.personal_details_header, 20);
		employeePage.edit_personal_details_button.click();
		employeePage.select_gender(gender).click();;
		commonUtils.selectValueFromDropDown(employeePage.marital_status_dropdown,maritalStatus);
		commonUtils.selectValueFromDropDown(employeePage.nationality_dropdown, nationality);
		employeePage.save_button.click();
		String message = employeePage.successful_message.getText();
		System.out.println(message);
	}
	
	public void addNewEmployee(String firstName, String lastName, int employeeId) {
		homePage.pim_module_link.click();
		commonUtils.watForVisibility(employeePage.add_new_employee_button, 20);
		employeePage.add_new_employee_button.click();
		commonUtils.watForVisibility(employeePage.add_employee_header, 20);
		System.out.println("******Adding new employee details******");
		employeePage.first_name_field.sendKeys(firstName);
		employeePage.last_name_field.sendKeys(lastName);
		employeePage.employee_id_field.clear();
		employeePage.employee_id_field.sendKeys(String.valueOf(employeeId));
	}
}
