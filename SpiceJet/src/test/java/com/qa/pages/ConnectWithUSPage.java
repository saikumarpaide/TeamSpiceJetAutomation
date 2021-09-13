package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectWithUSPage {
	public WebDriver driver;

	public ConnectWithUSPage  (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/a[1]/div/img")
	public WebElement Facebook;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/a[2]/div/img")
	public WebElement Twitter;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/a[3]/div/img")
	public WebElement Instagram;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/a[4]/div/img")
	public WebElement Youtube;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/a[5]/div/img")
	public WebElement WhatsApp;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFacebook() {
		return Facebook;
	}

	public WebElement getTwitter() {
		return Twitter;
	}

	public WebElement getInstagram() {
		return Instagram;
	}

	public WebElement getYoutube() {
		return Youtube;
	}

	public WebElement getWhatsApp() {
		return WhatsApp;
	}
	

}
