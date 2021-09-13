package com.qa.testscript;

import java.io.File;
import java.io.IOException;
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

import com.qa.pages.LoginAndSignupPage;
import com.qa.pages.StudentPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	
	LoginAndSignupPage loginandSignupPage;
	StudentPage page = null;

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

	public void captureScreenShot(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("done taking SS");

	}
	
	 
 

}
