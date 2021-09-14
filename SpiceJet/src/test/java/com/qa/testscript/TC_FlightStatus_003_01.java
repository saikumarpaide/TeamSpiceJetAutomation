package com.qa.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.pages.FlightStatusAndSearchPage;

public class TC_FlightStatus_003_01 extends TestBase {
	FlightStatusAndSearchPage fp;
	
	@Test
	public void flight_Status() throws IOException, InterruptedException {
		String DateStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

		fp=PageFactory.initElements(driver, FlightStatusAndSearchPage.class);
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TC_FlightStatus_003.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Search_Flight");
		
		fp.F_Status_module.click();
		fp.Date_DD.click();
		fp.Set_Date.click();
		fp.From_city_DD.click();
		driver.findElement(By.xpath("//div[text()='"+sh.getRow(1).getCell(0).getStringCellValue()+"']")).click();
		fp.International.click();
		driver.findElement(By.xpath("//div[text()='"+sh.getRow(1).getCell(1).getStringCellValue()+"']")).click();
		fp.Look_For_Status.click();
		Thread.sleep(10000);
		
		 File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     File destination = new File(System.getProperty("user.dir")+"\\SpiceJetAutomation\\"+DateStamp+".png");
	     FileUtils.copyFile(source, destination);
	        
	     wb.close();	}

}