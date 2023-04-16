package com.tests;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.orangehrm.commonmethods.EmployeeHelper;
import com.orangehrm.commonmethods.HomePageHelper;
import com.orangehrm.commonmethods.LoginPageHelper;
import com.orangehrm.pages.EmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.BaseClass;

public class OrangeHRMTests extends BaseClass {
	
	EmployeeHelper employeeHelper;
	LoginPage loginPage;
	LoginPageHelper loginPageHelper;
	Faker faker;
	HomePageHelper homePageHelper;
	EmployeePage employeePage;
	HomePage homePage;

	
	@BeforeClass
	public void initialize() {
		employeeHelper = new EmployeeHelper(driver);
		loginPage = new LoginPage(driver);
		loginPageHelper = new LoginPageHelper(driver);
		faker = new Faker();
		homePageHelper = new HomePageHelper(driver);
		employeePage = new EmployeePage(driver);
		homePage = new HomePage(driver);
	}
	
	@Test(priority = 1)
	public void verifyValidLogin() {
		test = extent.createTest("Verify Valid Login");
		loginPageHelper.login();
		test.info("Verify user is logged in successfully");
		Assert.assertTrue(homePage.dashboard_link.isDisplayed(), "Failed to login");
		test.pass("User logged in successfully");
		homePageHelper.logOut();
		
	}
	
	@Test(priority = 2)
	public void addNewEmployee() {
		test = extent.createTest("Verify addition of new employee");
		loginPageHelper.login();
		test.info("Verify user is logged in successfully");
		Assert.assertTrue(homePage.dashboard_link.isDisplayed(), "Failed to login");
		test.pass("User logged in successfully");
		String firstName = faker.name().firstName();
		System.out.println(firstName);
		String lastName = faker.name().lastName();
		System.out.println(lastName);
		int employeeId = Integer.parseInt(RandomStringUtils.randomNumeric(4));
		String username = firstName+lastName+"@"+"test.com";
		System.out.println("Username: "+username);
		String password = firstName+lastName+RandomStringUtils.randomNumeric(4);
		System.out.println("Password: "+password);
		String status = "Enabled";
		String gender = "Male";
		String maritalStatus = "Single";
		String nationality = "Indian";
		employeeHelper.addNewEmployeeAndCreateLogin(firstName, lastName, employeeId, username, password, status, gender, maritalStatus, nationality);
		test.info("Verify new employee saved successfully message displayed");
		Assert.assertEquals("Successfully Saved", employeePage.successful_message.getText());
		test.pass("New employee added successfully");
		homePageHelper.logOut();
	}
}
