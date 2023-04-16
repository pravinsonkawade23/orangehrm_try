package com.orangehrm.commonmethods;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.UserManagementPage;
import com.orangehrm.utilities.CommonUtils;

public class UserManagementHelper {
	WebDriver driver;
	HomePage homePage;
	CommonUtils commonUtils;
	UserManagementPage userManagmentPage;
	
	public UserManagementHelper(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(driver);
		commonUtils = new CommonUtils(driver);
		userManagmentPage = new UserManagementPage(driver);
	}
	
	public void addNewUser(String userRole) {
		homePage.admin_module_link.click();
		Assert.assertTrue(commonUtils.verifyIsDisplayed(userManagmentPage.system_users_header), "System users header not displayed");
		userManagmentPage.add_new_user_button.click();
		Assert.assertTrue(commonUtils.verifyIsDisplayed(userManagmentPage.add_user_header), "Add user header is not displayed");
		commonUtils.selectValueFromDropDown(userManagmentPage.user_role_dropdown, userRole);
	}
}
