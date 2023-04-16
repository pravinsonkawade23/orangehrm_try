package com.orangehrm.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	public WebDriver driver;
	ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test; 
	CommonUtils commonUtils = null;
	
	@BeforeClass
	public void setUp() {
		driver = new Driver().getDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ConfigurationReader.getProperty("url"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeSuite
	public void reportSetup() {
		String getDate = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
		System.out.println(getDate);
		sparkReporter = new ExtentSparkReporter(".//reports//"+getDate+"test_report.html");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Aniket");
		extent.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
	}
	
	@AfterSuite
	public void publishReport() {
		extent.flush();
		
		try {
			commonUtils.sendEmail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void testStatus(ITestResult result) {
		commonUtils = new CommonUtils(driver);
		
		if(ITestResult.SUCCESS == result.getStatus()) {
			test.log(Status.PASS, result.getName());
		}
		if(ITestResult.FAILURE == result.getStatus()) {
			test.log(Status.FAIL, result.getName());
			String path = commonUtils.getScreenshot(result.getName());
//			System.out.println(path);
			test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(path).build());
			commonUtils.waitPlease(3);
			test.addScreenCaptureFromBase64String(path);
			commonUtils.waitPlease(3);
		}
		if(ITestResult.SKIP == result.getStatus()) {
			test.log(Status.SKIP, result.getName());
		}
	}
}
