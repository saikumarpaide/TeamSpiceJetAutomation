package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.FooterLinksPage;
import com.qa.utility.ExtentTestManager;

public class TC_FooterLinks_001 extends TestBase {
	FooterLinksPage pages;
	@Test
	public void checkFooterLinks(Method method) throws Exception {
		exTest = ExtentTestManager.startTest(method.getName(), "checkFooterLinks");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(5000);
		
		 pages = new FooterLinksPage(driver);
		Actions action = new Actions(driver);
		
		
		action.click(pages.getHomeLink()).build().perform();
		Thread.sleep(3000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(3000);
		
		action.click(pages.getPrivacyPolicyLink()).build().perform();
		Thread.sleep(5000);
		
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(3000);
		

		action.click(pages.getTermsAndConditions()).build().perform();
		Thread.sleep(3000);

		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(3000);
		
		action.click(pages.getGstInformation()).build().perform();
		Thread.sleep(3000);
		
		JavascriptExecutor js13 = (JavascriptExecutor) driver;
		js13.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(3000);

		action.click(pages.getSiteMap()).build().perform();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-2000)","");
		Thread.sleep(3000);
		
		String Parent_win= driver.getWindowHandle();
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		Reporter.log("No of Tabs are ==>"+tabs.size());
		for(String tab:tabs) {
			driver.switchTo().window(tab);
			Reporter.log(driver.getTitle());
			captureScreenshot(driver, method.getName());
			Thread.sleep(2000);
		}
		
	}
	
		
}



