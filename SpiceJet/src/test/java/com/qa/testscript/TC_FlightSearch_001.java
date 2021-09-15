package com.qa.testscript;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.FlightStatusAndSearchPage;
import com.qa.testdata.ExcelData;
import com.qa.utility.ExtentTestManager;

public class TC_FlightSearch_001 extends TestBase {
	FlightStatusAndSearchPage fp;
	ExcelData ed;	
	
	@Test
	public void FlightSearch(Method method) throws  Exception {
		WebDriverWait w = new WebDriverWait(driver, 7);
		
		exTest = ExtentTestManager.startTest(method.getName(), "Flight Search");
		
		ed = PageFactory.initElements(driver, ExcelData.class);

		fp=PageFactory.initElements(driver, FlightStatusAndSearchPage.class);
		
		Actions a = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fp.Round_Trip.click();
		fp.From_city_DD.click();
		
		 String xlpath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\TC_FlightStatus_003.xlsx";	 
		 System.out.println("Excel is located at :"+xlpath);		 
         String Sheetname = "Search_Flight";
         int No_ofRows = ed.getRowCount(xlpath, Sheetname);
         System.out.println("No of rows are: "+No_ofRows);
         
         for (int row=1;row<= No_ofRows;row++){  
        	 Reporter.log("entered Into Excelsheet");
			driver.findElement(By.xpath("//div[text()='"+ed.getCellValue(xlpath, Sheetname, row, 0)+"']")).click();
			fp.International.click();
			driver.findElement(By.xpath("//div[text()='"+ed.getCellValue(xlpath, Sheetname, row, 1)+"']")).click();
			driver.findElement(By.xpath("//div[text()='"+ed.getCellValue(xlpath, Sheetname,row, 2)+"']")).click();
			driver.findElement(By.xpath("//div[text()='"+ed.getCellValue(xlpath, Sheetname, row, 3)+"']")).click();
	    }
         
		fp.Passengers.click();
		int No_Adult= 2;
		for(int i=0;i<No_Adult;i++) {
			fp.Select_Adult.click();
		}
		fp.Select_Children.click();
		a.moveToElement(fp.Click_Done).click().build().perform();
		
		fp.Select_Student.click();
		
		a.moveToElement(fp.Search_Flight).click().build().perform();
		if(driver.findElement(By.xpath("//div[text()='Mandatory Guidelines arriving into UAE']")).isDisplayed()) {
			fp.I_Agree.click();
			Thread.sleep(3000);
		}
		fp.Student_checkbox.click();
		Thread.sleep(3000);
		fp.Std_Continue.click();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(5000);	
		 String Expected =driver.getTitle();
		Assert.assertEquals(Expected, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		
	
		captureScreenshot(driver, method.getName());
		
//        File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomation\\"+DateStamp+".png");
//        FileUtils.copyFile(source, destination); 
        
	}
		
}
