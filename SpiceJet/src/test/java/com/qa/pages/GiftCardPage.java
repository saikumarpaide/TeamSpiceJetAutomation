package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage {
	public WebDriver driver;

	public GiftCardPage(WebDriver  driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Gift Card")
	public WebElement giftCardLink;
	@FindBy(linkText = "E-Gift card")
	public WebElement SelectGC;
	
	// ************ data
	
	@FindBy(xpath = "//*[@id='funValidateControls']/div[1]/div/div[1]/div[5]/div[1]/div/div[1]/div/div[2]/input")
	public WebElement denomination;
	@FindBy(xpath = "//textarea[@placeholder='Your Message:']")
	public WebElement message;
	@FindBy(id = "quantity")
	public WebElement quantity;
	
	//******Senders Details*///
	@FindBy(css ="[ng-model='Input.senderName']" )
	public WebElement senderName;
	@FindBy(css = "[ng-model='Input.senderEmail']")
	public WebElement senderEmail ;
	@FindBy(css = "[ng-model='Input.senderAddressline_1']")
	public WebElement addressLine1 ;
	@FindBy(css ="[ng-model='Input.senderLine_2']" )
	public WebElement addressLine2;
	@FindBy(css = "[ng-model='Input.senderPincode']")
	public WebElement  pinCode;
	@FindBy(xpath = "//input[@placeholder='City*']")
	public WebElement city;
	@FindBy(css ="[ng-model='Input.senderState']" )
	public WebElement  State;
	@FindBy(css = "[ng-model='Input.senderMobileno']")
	public WebElement  senderContactNumber;
	//************ Receivers Details
	
	@FindBy(css = "[ng-model='Input.receiverName']")
	public WebElement receiverName;
	@FindBy(id = "remail")
	public WebElement receiverEmail ;
	@FindBy(css = "[ng-model='Input.receiverReEnterEmail']")
	public WebElement receiverEmail2 ;
	@FindBy(css = "[ng-model='Input.receiverMobileno']")
	public WebElement receiverContactNumber;
	 
	//************Check box and submit button
	

	@FindBy(css ="[ng-model='Input.terms_checked']" )
	public WebElement termsAndConditions;
	@FindBy(css = "\"[ng-keypress='handlepaybtnenter($event)']\"" )
	public WebElement submitButton;

	
	//**********Getters

	public WebElement getGiftCardLink() {
		return giftCardLink;
	}
	public WebElement getSelectGC() {
		return SelectGC;
	}
	public WebElement getDenomination() {
		return denomination;
	}
	public WebElement getMessage() {
		return message;
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public WebElement getSenderName() {
		return senderName;
	}
	public WebElement getSenderEmail() {
		return senderEmail;
	}
	public WebElement getAddressLine1() {
		return addressLine1;
	}
	public WebElement getAddressLine2() {
		return addressLine2;
	}
	public WebElement getPinCode() {
		return pinCode;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getState() {
		return State;
	}
	public WebElement getSenderContactNumber() {
		return senderContactNumber;
	}
	public WebElement getReceiverName() {
		return receiverName;
	}
	public WebElement getReceiverEmail() {
		return receiverEmail;
	}
	public WebElement getReceiverEmail2() {
		return receiverEmail2;
	}
	public WebElement getReceiverContactNumber() {
		return receiverContactNumber;
	}
	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	///****************************
	@FindBy(xpath = "//*[@id='contentPages']/div/div[1]/div[1]/div[3]/a[2]/span")
	public WebElement appLink;
	@FindBy(xpath = "//section[@class='top-bar-section']//a[.='Congratulations']")
	public WebElement selectLink;

	public WebElement getAppLink() {
		return appLink;
	}
	public WebElement getSelectLink() {
		return selectLink;
	}
	
		
	
}
