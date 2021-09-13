package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPackage {
	public WebDriver driver;

	public HotelPackage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(text(),'Hotels')]")
	public WebElement hotelLink;

	@FindBy(xpath = "//input[@id='txtHotelCity']")
	public WebElement enterName;

	@FindBy(xpath = "//input[@id='from']")
	public WebElement calenderClick;

	public WebElement getHotelLink() {
		return hotelLink;
	}

	@FindBy(xpath = "//a[contains(text(),'Search Now')]")
	public WebElement searchNow;

	public WebElement getEnterName() {
		return enterName;
	}

	public WebElement getCalenderClick() {
		return calenderClick;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}

}
