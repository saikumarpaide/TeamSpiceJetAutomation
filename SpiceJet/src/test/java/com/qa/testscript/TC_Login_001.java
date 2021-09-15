package com.qa.testscript;

import java.lang.reflect.Method;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.LoginAndSignupPage;
import com.qa.utility.ExtentTestManager;

public class TC_Login_001 extends TestBase {

	
	  @Test public void Loginform(Method method) throws Exception {
		exTest = ExtentTestManager.startTest(method.getName(), "Loginform");

	 	loginandSignupPage = new LoginAndSignupPage(driver);
	 	driver.navigate().refresh();
		loginandSignupPage.getLogin().click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.click(loginandSignupPage.getMobilenumberbutton()).build().perform();
		
		Thread.sleep(2000);
		loginandSignupPage.getEntermobilenumber().sendKeys("9843667247");
		Thread.sleep(2000);
		loginandSignupPage.getEnterpassword().sendKeys("Bhargavi*12");
		Thread.sleep(2000);
		loginandSignupPage.getLoginbutton().click();
		Thread.sleep(2000);
		captureScreenshot(driver, method.getName());
	}
	


}
