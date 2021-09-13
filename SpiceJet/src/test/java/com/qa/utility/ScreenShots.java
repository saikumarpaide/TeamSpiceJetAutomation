package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
	 
	public class ScreenShots {
		public static Logger APPLICATION_LOGS = null;
		
		public static String timestamp() {
			return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}


	    public static void capture1(WebDriver driver,String screenShotName,ExtentTest tes) throws IOException {
	    	
	    	String base64String=null;
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+timestamp()+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination); 
	        byte[] filecon=FileUtils.readFileToByteArray(source);
	        base64String="data:image/png;base64,"+Base64.getEncoder().encodeToString(filecon);
	       // tes.log(Status.FAIL, tes.addScreenCaptureFromBase64String(base64String));
	        
	    	

	}
}