package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpiceJetStudentDiscountPage {

	public WebDriver driver;

	public SpiceJetStudentDiscountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(tagName = "a"))
	public List<WebElement> allLinks;

	public List<WebElement> getAllLinks() {
		return allLinks;
	}

}
