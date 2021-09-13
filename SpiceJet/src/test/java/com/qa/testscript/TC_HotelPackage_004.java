package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.pages.HotelPackage;

public class TC_HotelPackage_004 extends TestBase {
	HotelPackage hotel;

	@Test
	public void HotelPackageForm() throws IOException {
		List<WebElement> searchPageResults;
		List<String> allLinkText = new ArrayList<>();
		String month = "October";
		hotel = new HotelPackage(driver);
		hotel.getHotelLink().click();
		sleep();
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator = windowId.iterator();
		while (iterator.hasNext()) {
			String newWindowId = iterator.next();
			driver.switchTo().window(newWindowId);

		}
		hotel.getEnterName().sendKeys("Manali");
		sleep();
		hotel.getEnterName().sendKeys(Keys.ARROW_DOWN);
		hotel.getEnterName().sendKeys(Keys.ARROW_DOWN);
		hotel.getEnterName().sendKeys(Keys.ENTER);
		sleep();
		hotel.getCalenderClick().click();
		String calenderMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		boolean ans = true;
		while (true) {
			String text = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
			}
		}

		driver.findElement(By.xpath("//a[contains(text(),'19')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'20')]")).click();
		hotel.getSearchNow().click();
		sleep();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sleep();
		js.executeScript("window.scrollBy(0,1000)", "");
		sleep();
		searchPageResults = driver.findElements(By.xpath("//div[@class='details col-sm-7 col-md-8']"));
		// searchPageResults=driver.findElements(By.xpath("//div[@class='details
		// col-sm-7 col-md-8']"));
		for (WebElement link : searchPageResults) {
			allLinkText.add(link.getText());

		}

		for (String eachLinkText : allLinkText) {
			System.out.println();
			System.out.println(eachLinkText + "\r\n");
			System.out.println("--------------------------------");
		}
		
		madeScreenShots();

		driver.quit();
	}

	public void madeScreenShots() throws IOException {
		String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		 File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomation\\"+DateStamp+".png");
	     FileUtils.copyFile(source, destination);
	     
		}
	public void sleep() {
		try {
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}