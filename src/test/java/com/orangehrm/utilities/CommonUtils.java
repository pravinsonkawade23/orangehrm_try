package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	WebDriver driver;

	public CommonUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used for wait till visibility of webelement
	 * 
	 * @param element       - webelement to wait
	 * @param timeinSeconds - time in seconds
	 * @return
	 */
	public WebElement watForVisibility(WebElement element,int timeinSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to verify WebElement displayed
	 * 
	 * @param element
	 */
	public boolean verifyIsDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			System.out.println("PASSED");
			System.out.println(element.getText() + ": is visible");
			return true;
		}catch (NoSuchElementException e) {
			System.out.println("FAILED");
			System.out.println(element.getText() + ": is not visible!");
			return false;
		}
		
	}
	
	public void selectValueFromDropDown(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		System.out.println(element+" is selected");
	}
	
	public String getScreenshot(String name) {
		String  getDate = new SimpleDateFormat("yyyy-MM-dd-hh-mm").format(new Date());
		File capture = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//ScreenShot//"+name+getDate+".png";
		String base64Screenshot = null ;
		try {
			FileUtils.copyFile(capture, new File(path));
			byte[] screenShotBytes = IOUtils.toByteArray(new FileInputStream(path));
			base64Screenshot = Base64.getEncoder().encodeToString(screenShotBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base64Screenshot;
	}
	
	public void waitPlease(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEmail() throws EmailException {
		System.out.println("*******Sending Email********");
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("aniketsample23", "Welcome@1254"));
		email.setSSLOnConnect(true);
		email.setFrom("aniketsample@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("aniketk@testrig.co.in");
		email.send();
		System.out.println("*******Email Sent********");
	}

}
