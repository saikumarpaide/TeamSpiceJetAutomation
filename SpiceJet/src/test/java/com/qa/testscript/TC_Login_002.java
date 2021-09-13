package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.LoginAndSignupPage;

public class TC_Login_002 extends TestBase {

	
	  @Test public void Loginform() throws InterruptedException, IOException {
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
		
		madeScreenShots();
	}
	  public void madeScreenShots() throws IOException {
			String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
			 File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomation\\"+DateStamp+".png");
		     FileUtils.copyFile(source, destination);
		     
			}
	


}
