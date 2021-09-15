package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightStatusAndSearchPage {
	WebDriver driver;
	
	public FlightStatusAndSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//div[text()='round trip']/preceding-sibling::*")
	public WebElement Round_Trip;
	
	@FindBy(xpath = "//div[text()='From']/parent::*")
	public WebElement From_city_DD;
	
	@FindBy(xpath = "//div[text()='International']")
	public WebElement International;
	
	@FindBy(xpath = "//div[text()='Passengers']")
	public WebElement Passengers;
	
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']/div[2]/div[3]")
	public WebElement Select_Adult;
	
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']/div)[4]/div[3]")
	public WebElement Select_Children;
	
	@FindBy(xpath = "//div[text()='Done']")
	public WebElement Click_Done;
	
	@FindBy(xpath = "//div[text()='Students']/preceding-sibling::*")
	public WebElement Select_Student;
	
	@FindBy(xpath = "//div[text()='Search Flight']")
	public WebElement Search_Flight;
	
	@FindBy(xpath = "//div[text()='I AGREE']")
	public WebElement I_Agree;
	
	@FindBy(xpath = "//div[text()='Student Discount Bookings']/following::div[7]")
	public WebElement Student_checkbox;
	
	@FindBy(xpath = "(//div[text()='Continue'])[2]/parent::*")
	public WebElement Std_Continue;

	//these are for Flight_status_module
	@FindBy(xpath = "//div[text()='flight status']")
	public WebElement F_Status_module;
	
	@FindBy(xpath = "//div[text()='Departure Date']/parent::*")
	public WebElement Date_DD;
	
	@FindBy(xpath = "//div[text()='Tomorrow']/parent::*")
	public WebElement Set_Date;

	@FindBy(xpath = "//div[text()='Search Flights']/parent::*")
	public WebElement Look_For_Status;
	
	
}

