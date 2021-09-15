package com.qa.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.LoginAndSignupPage;
import com.qa.utility.ExtentTestManager;

public class TC_SignUp_001 extends TestBase {
	
	
	public void sleep() {
		try {
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}


	@Test
	public void Signupform(Method method) throws Exception {
		exTest =ExtentTestManager.startTest(method.getName(),"Signupform");
		
		//driver.manage().window().fullscreen();
		//driver.navigate().refresh();
		
		
		loginandSignupPage = new LoginAndSignupPage(driver);
		Actions actions = new Actions(driver);
		
		
		actions.click(loginandSignupPage.getSignup()).build().perform();
		actions.click(loginandSignupPage.getGenderTitle()).build().perform();
		actions.click(loginandSignupPage.getSelectGender()).build().perform();
		
		loginandSignupPage.getFirstName().sendKeys("Bhargavi");
		loginandSignupPage.getLastName().sendKeys("Karanam");
		
		actions.click(loginandSignupPage.getCountry()).build().perform();
		actions.click(loginandSignupPage.getSearchCountry()).build().perform();
		sleep();
		loginandSignupPage.getSearchCountry().sendKeys("India");
		sleep();
		loginandSignupPage.getSelectCountry().click();
		sleep();
		//**********DOB ************//
		
		actions.click(loginandSignupPage.getDateOfBirth()).build().perform();
		sleep();	
		//driver.manage().window().fullscreen();
		actions.click(loginandSignupPage.getClickOnYear()).build().perform();
		sleep();
		actions.click(loginandSignupPage.getSelectYear()).build().perform();
		sleep();
		actions.click(loginandSignupPage.getMonth()).build().perform();
		
		actions.click(loginandSignupPage.getDate()).build().perform();
		
		//*********************************************************************
		loginandSignupPage.getContactNumber().sendKeys("8522819226");
		loginandSignupPage.getPassword().sendKeys("Bhargavi@12");
		loginandSignupPage.getConfirmPassword().sendKeys("Bhargavi@12");
		loginandSignupPage.getEmailAddress().sendKeys("bhargavi@gmail.com");
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
		
		//loginandSignupPage.getCheckboxTC().click();
		loginandSignupPage.getSignupBtn().click();
		
		captureScreenshot(driver, method.getName());
	}
	

	
}
