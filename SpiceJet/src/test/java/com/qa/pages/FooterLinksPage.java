package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterLinksPage {
	
	public WebDriver driver;

	public FooterLinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Home']")
	public WebElement homeLink;

	@FindBy(xpath = "//div[text()='Privacy Policy']")
	public WebElement privacyPolicyLink;

	@FindBy(xpath = "//div[text()='Terms and Conditions']")
	public WebElement termsAndConditions;
	
	@FindBy(xpath="//div[text()='GST Information']")
	public WebElement gstInformation;
	
	@FindBy(xpath="//div[text()='Sitemap']")
	public WebElement siteMap;

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}

	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	public WebElement getGstInformation() {
		return gstInformation;
	}

	public WebElement getSiteMap() {
		return siteMap;
	}
	

}
