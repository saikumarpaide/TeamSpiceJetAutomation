package com.qa.testscript;

import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.FlightStatusAndSearchPage;
import com.qa.testdata.ExcelData;
import com.qa.utility.ExtentTestManager;

public class TC_FlightStatus_001 extends TestBase {
	FlightStatusAndSearchPage fp;
	ExcelData ed;	
	
	@Test
	public void flight_Status(Method method) throws Exception {
		
		WebDriverWait w = new WebDriverWait(driver, 7);
		
		ed = PageFactory.initElements(driver, ExcelData.class);

		exTest =ExtentTestManager.startTest(method.getName(), "flight_Status");
		
		fp=PageFactory.initElements(driver, FlightStatusAndSearchPage.class);
		String xlpath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\TC_FlightStatus_001.xlsx";	 
		System.out.println("Excel is located at :"+xlpath);		 
        String Sheetname = "Search_Flight";
		fp.F_Status_module.click();
		fp.Date_DD.click();
		fp.Set_Date.click();
		fp.From_city_DD.click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+ed.getCellValue(xlpath, Sheetname, 1, 0)+"']"))).click();
		fp.International.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='"+ed.getCellValue(xlpath, Sheetname,1,1)+"']")).click();
		Thread.sleep(2000);
		fp.Look_For_Status.click();
		String Expected =driver.getTitle();
		String Actual= "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(Expected, Actual);
		Thread.sleep(5000); 
		captureScreenshot(driver, method.getName()); 
	  }
}