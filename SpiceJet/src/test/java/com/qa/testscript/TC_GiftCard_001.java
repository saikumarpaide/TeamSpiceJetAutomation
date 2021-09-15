package com.qa.testscript;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.GiftCardPage;
import com.qa.utility.ExtentTestManager;

public class TC_GiftCard_001 extends TestBase {

	GiftCardPage cardPage = null;
	Actions actions = null;

	@Test
	public void ClickLinkOfGC(Method method) throws Exception {
		exTest =ExtentTestManager.startTest(method.getName(), "ClickLinkOfGC");
		cardPage = new GiftCardPage(driver);
		actions = new Actions(driver);
		
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
		Thread.sleep(3000);
		cardPage.getQuantity().sendKeys(Keys.ENTER);
		
		// **********Senders Details**************

		cardPage.getSenderName().sendKeys("Kranti Rao");
		cardPage.getSenderEmail().sendKeys("krantirao@gmail.com");
		cardPage.getAddressLine1().sendKeys("new Colony");
		cardPage.getAddressLine2().sendKeys("hanumakonda");
		cardPage.getPinCode().sendKeys("500601");
		cardPage.getCity().sendKeys("Waranagal");
		cardPage.getState().sendKeys("Telangana");
		cardPage.getSenderContactNumber().sendKeys("8522819226");
		
		// **********Receivers Details

		cardPage.getReceiverName().sendKeys("Saikumar Paide");
		cardPage.getReceiverEmail().sendKeys("saikumarpaide796@gmail.com");
		cardPage.getReceiverEmail2().sendKeys("saikumarpaide796@gmail.com");
		cardPage.getReceiverContactNumber().sendKeys("8019776844");
		// ***********check box and submit
		
		cardPage.getTermsAndConditions().click();
		captureScreenshot(driver, method.getName());
		Thread.sleep(2000);

	}

	
}
