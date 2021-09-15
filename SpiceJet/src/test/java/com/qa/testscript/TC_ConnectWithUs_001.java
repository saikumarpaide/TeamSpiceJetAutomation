package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.ConnectWithUSPage;
import com.qa.utility.ExtentTestManager;

public class TC_ConnectWithUs_001 extends TestBase {
	ConnectWithUSPage pages;

	@Test
	public void ConnectWithUs(Method method) throws InterruptedException, IOException {
		exTest =ExtentTestManager.startTest(method.getName(), "ConnectWithUs");

		pages = new ConnectWithUSPage(driver);
		Actions action = new Actions(driver);
		madeScreenShots();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(5000);
		madeScreenShots();

		action.click(pages.getFacebook()).perform();
		madeScreenShots();
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1500)", "");
		madeScreenShots();
		
		action.click(pages.getTwitter()).perform();
		madeScreenShots();
		
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,1500)", "");

		action.click(pages.getInstagram()).perform();
		madeScreenShots();

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,1500)", "");

		action.click(pages.getYoutube()).perform();
		madeScreenShots();

		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("window.scrollBy(0,1500)", "");

		action.click(pages.getWhatsApp()).perform();
		madeScreenShots();

	}
	
	public void madeScreenShots() throws IOException {
		String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		 File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomation\\"+DateStamp+".png");
	     FileUtils.copyFile(source, destination);
	     
		}
}