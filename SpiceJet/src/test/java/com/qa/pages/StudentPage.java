package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPage {
	WebDriver driver;
	public StudentPage(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		public WebElement getAdd_mouseClick() {
		    return Add_mouseClick;
	}
		
		public WebElement getStudentTargetLink() {
		    return StudentTargetLink;
	}
		
	@FindBy(xpath = "//*[@id='main-container']/div/div[1]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[1]")
	public WebElement Add_mouseClick;
	@FindBy(xpath = "//*[@id='main-container']/div/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[7]/div/a[1]/div/div")
	public WebElement StudentTargetLink;

}
