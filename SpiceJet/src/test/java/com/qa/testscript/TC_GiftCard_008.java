package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.GiftCardPage;

public class TC_GiftCard_008 extends TestBase {

	GiftCardPage cardPage = null;
	Actions actions = null;

	@Test(priority = 1)
	public void ClickLinkOfGC() throws InterruptedException, IOException {
		cardPage = new GiftCardPage(driver);
		actions = new Actions(driver);
		madeScreenShots();
		actions.click(cardPage.giftCardLink).build().perform();
		
		Set<String> newWindowId = driver.getWindowHandles();
		Iterator<String> iterator = newWindowId.iterator();

		while (iterator.hasNext()) {
			String newId = iterator.next();
			driver.switchTo().window(newId);
			if (driver.getTitle().equalsIgnoreCase("SpiceJet Gift Cards")) {
				driver.get("https://spicejet.woohoo.in/congratulations");
			}

		}

		// actions.click(cardPage.getSelectLink()).click();

//************  data*****************//
		
		Thread.sleep(5000);
		cardPage.getDenomination().sendKeys("49000");
		cardPage.getMessage().sendKeys("Congratualtions for your new Job");
		actions = new Actions(driver);
		actions.click(cardPage.getQuantity()).build().perform();

		cardPage.getQuantity().sendKeys("5");
		Thread.sleep(30200);
		cardPage.getQuantity().sendKeys(Keys.ENTER);
		madeScreenShots();

		// **********Senders Details**************

		cardPage.getSenderName().sendKeys("Kranti Rao");
		cardPage.getSenderEmail().sendKeys("krantirao@gmail.com");
		cardPage.getAddressLine1().sendKeys("new Colony");
		cardPage.getAddressLine2().sendKeys("hanumakonda");
		cardPage.getPinCode().sendKeys("500601");
		cardPage.getCity().sendKeys("Waranagal");
		cardPage.getState().sendKeys("Telangana");
		cardPage.getSenderContactNumber().sendKeys("8522819226");
		madeScreenShots();

		// **********Receivers Details

		cardPage.getReceiverName().sendKeys("Saikumar Paide");
		cardPage.getReceiverEmail().sendKeys("saikumarpaide796@gmail.com");
		cardPage.getReceiverEmail2().sendKeys("saikumarpaide796@gmail.com");
		cardPage.getReceiverContactNumber().sendKeys("8019776844");
		// ***********check box and submit
		madeScreenShots();
		cardPage.getTermsAndConditions().click();

	}

	public void madeScreenShots() throws IOException {
		String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\SpiceJetAutomation\\" + DateStamp + ".png");
		FileUtils.copyFile(source, destination);

	}
}
