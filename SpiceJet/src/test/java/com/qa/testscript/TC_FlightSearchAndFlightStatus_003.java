package com.qa.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.pages.FlightStatusAndSearchPage;
import com.qa.testdata.TestData;

public class TC_FlightSearchAndFlightStatus_003 extends TestBase{
	FlightStatusAndSearchPage fp;
	TestData td;	
	
	@Test
	public void FlightSearch() throws  Exception {
		String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TC_FlightStatus_003.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Search_Flight");
		
		
		Actions a = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fp=PageFactory.initElements(driver, FlightStatusAndSearchPage.class);
		fp.Round_Trip.click();
		fp.From_city_DD.click();
		driver.findElement(By.xpath("//div[text()='"+sh.getRow(1).getCell(0).getStringCellValue()+"']")).click();
		fp.International.click();
		driver.findElement(By.xpath("//div[text()='"+sh.getRow(1).getCell(1).getStringCellValue()+"']")).click();
		driver.findElement(By.xpath("//div[text()='"+sh.getRow(1).getCell(2).getStringCellValue()+"']")).click();
		driver.findElement(By.xpath("//div[text()='"+sh.getRow(1).getCell(3).getStringCellValue()+"']")).click();
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
			
		}
		fp.Student_checkbox.click();
		Thread.sleep(3000);
		fp.Std_Continue.click();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(5000);	
		
	
        File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomationScreenshots\\"+DateStamp+".png");
        FileUtils.copyFile(source, destination); 
        
        wb.close();
	}
	
	
}
