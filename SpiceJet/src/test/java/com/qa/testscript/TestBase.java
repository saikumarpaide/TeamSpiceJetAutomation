package com.qa.testscript;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.LoginAndSignupPage;
import com.qa.pages.StudentPage;
import com.qa.utility.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public ExtentTest exTest;
	public ExtentReports exReports;
	public int Success_tests= 0;
	public int Failed_Tests=0;
	public int Skip_Tests=0;

	public WebDriver driver;
	
	LoginAndSignupPage loginandSignupPage;
	StudentPage page = null;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	@BeforeClass
	@Parameters("HomeUrl")
	public void setUp(String url) {
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");

		// INIT CHROME OPTIONS
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// SET CHROME OPTIONS
		// 0 - Default, 1 - Allow, 2 - Block
		contentSettings.put("geolocation", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		// SET CAPABILITY
		caps.setCapability(ChromeOptions.CAPABILITY, options);

		options.addArguments("--disable-notifications");
		options.addArguments("start-maximized");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page = new StudentPage(driver);
		driver.get(url);

		System.out.println("SETUP");

	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			 driver.quit();
		}
	}
	
	public  String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}


    public void captureScreenshot(WebDriver driver ,String MethodName) throws Exception   {
    	
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\Screenshots\\"+MethodName+"-"+timestamp()+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination); 
      
}

	
}
