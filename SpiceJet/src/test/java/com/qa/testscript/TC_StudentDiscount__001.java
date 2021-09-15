package com.qa.testscript;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.pages.SpiceJetStudentDiscountPage;
import com.qa.utility.ExtentTestManager;

public class TC_StudentDiscount__001 extends TestBase {

	private static final String title_Page = "Spicejet Student Discount Offer";
	SpiceJetStudentDiscountPage discountPage = null; 

	@Test(priority = 1)
	public void clickAddon(Method method) throws Exception {
		exTest =ExtentTestManager.startTest(method.getName(), "clickAddon");

		Thread.sleep(10000);
		System.out.println("1");
		Actions actions = new Actions(driver);
		WebElement AddonLink = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
		actions.click(AddonLink).build().perform();
		Thread.sleep(10000);
		System.out.println("2");
		WebElement StudentLink = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[7]/div[1]/a[1]/div[1]/div[1]"));
		actions.click(StudentLink).build().perform();
	
			Set<String> windowId = driver.getWindowHandles();
			Iterator<String> iterator = windowId.iterator();
			
			while(iterator.hasNext()) {
				String newWindowId = iterator.next();
				driver.switchTo().window(newWindowId);
				if(driver.getTitle().contains("SpiceJet Student Discount Offer")) {
					System.out.println(driver.getTitle());
				}
		}

		
	}
	@Test(priority = 2)
	public void siteLinks() {
		discountPage = new SpiceJetStudentDiscountPage(driver);
		List<WebElement> alllinks = discountPage.getAllLinks();
		for (WebElement webElement : alllinks) {
			System.out.println(webElement.getText());
		}
	}

}
