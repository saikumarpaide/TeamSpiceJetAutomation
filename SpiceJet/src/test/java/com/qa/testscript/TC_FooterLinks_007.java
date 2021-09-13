package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.FooterLinksPage;

public class TC_FooterLinks_007 extends TestBase {
	FooterLinksPage pages;
	@Test
	public void checkFooterLinks() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)","");
		Thread.sleep(5000);
		
		 pages = new FooterLinksPage(driver);
		Actions action = new Actions(driver);
		
		
		action.click(pages.getHomeLink()).perform();
		madeScreenShots();
		Thread.sleep(3000);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,2000)","");
		madeScreenShots();
		Thread.sleep(3000);
		
		action.click(pages.getPrivacyPolicyLink()).perform();
		madeScreenShots();
		Thread.sleep(5000);
		
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,2000)","");
		madeScreenShots();
		Thread.sleep(3000);
		

		action.click(pages.getTermsAndConditions()).perform();
		madeScreenShots();
		Thread.sleep(3000);

		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("window.scrollBy(0,2000)","");
		madeScreenShots();
		Thread.sleep(3000);
		
		action.click(pages.getGstInformation()).perform();
		madeScreenShots();
		Thread.sleep(3000);
		
		JavascriptExecutor js13 = (JavascriptExecutor) driver;
		js13.executeScript("window.scrollBy(0,2000)","");
		madeScreenShots();
		Thread.sleep(3000);

		action.click(pages.getSiteMap()).perform();
		madeScreenShots();
		Thread.sleep(3000);

		
		
	}
	public void madeScreenShots() throws IOException {
		String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		 File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomation\\"+DateStamp+".png");
	     FileUtils.copyFile(source, destination);
	     
		}

}



