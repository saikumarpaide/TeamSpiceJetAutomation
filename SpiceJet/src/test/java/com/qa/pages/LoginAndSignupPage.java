package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndSignupPage {
	public WebDriver driver;

	public LoginAndSignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[2]/div/div/div[3]/div[2]/div/div")
	public WebElement signup;
	//************ SignUp Page ***********************/
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-13qz1uu']/div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")
	public WebElement genderTitle;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div[4]/div/div")
	public WebElement selectGender;
	@FindBy(css = "[placeholder='e.g. John']")
	public WebElement firstName;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]/div/div[2]/input")
	public WebElement lastName;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-tmtnm0 r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-13qz1uu']//div[@class='css-76zvg2 css-bfa6kz r-ubezar']")
	public WebElement country;
	@FindBy(css = "[placeholder='Search']")
	public WebElement searchCountry;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-13qz1uu r-8fdsdq']//div[@class='css-1dbjc4n r-1niwhzg r-1loqt21 r-1otgn73 r-lrvibr']/div[.='India']")
	public WebElement selectCountry;
	@FindBy(css = "[placeholder='DD/MM/YYYY']")
	public WebElement dateOfBirth;
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-adyw6z r-1kfrs79']")
	public WebElement clickOnYear;
	@FindBy(xpath = "//div[20]/div[@class='css-76zvg2 r-edyy15 r-q4m81j']")
	public WebElement selectYear;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[@class='css-1dbjc4n r-1loqt21 r-12zupyf r-1otgn73']/div[.='May']")
	public WebElement month;
	@FindBy(xpath = "//div[25]/div[@class='css-76zvg2 r-1awozwy r-14lw9ot r-qsz3a2 r-6koalj r-1r8g8re r-1777fci r-1acpoxo']")
	public WebElement date;
	@FindBy(css = "[placeholder='e.g. 9876-453-010']")
	public WebElement contactNumber;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div[7]/div/div[2]/input")
	public WebElement password;
	@FindBy(xpath = "//*[@id='main-container']/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div[8]/div/div[2]/input")
	public WebElement confirmPassword;
	@FindBy(css = "[placeholder='johndoe@example.com']")
	public WebElement emailAddress;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1otgn73']//div[@class='css-1dbjc4n r-zso239']//*[local-name()='svg']//*[name()='g']//*[name()='g' and contains(@fill,'none')]//*[name()='path'][2]")
	public WebElement checkboxTC;
	@FindBy(xpath = "//*[@id='main-container']/div/div[1]/div/div[2]/div/div[2]/div/div[5]/div")
	public WebElement signupBtn;
	
	// **********Getters for SignUp Page********//
	public WebElement getSignup() {
		return signup;
	}

	public WebElement getGenderTitle() {
		return genderTitle;
	}

	public WebElement getSelectGender() {
		return selectGender;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCountry() {
		return country;
	}
	public WebElement getSearchCountry() {
		return searchCountry;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public WebElement getDateOfBirth() {
		return dateOfBirth;
	}

	public WebElement getClickOnYear() {
		return clickOnYear;
	}

	public WebElement getSelectYear() {
		return selectYear;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getContactNumber() {
		return contactNumber;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getCheckboxTC() {
		return checkboxTC;
	}

	public WebElement getSignupBtn() {
		return signupBtn;
	}
	
	////////////////////////**************Login Page*************///////////
	
	//***********Login Page****************************
		@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[2]/div/div/div[3]/div[1]/div/div")
		public WebElement Login;

		@FindBy(xpath = "//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-p1pxzi']//div[1]//div[1]//*[local-name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle'][2]")
		public WebElement Mobilenumberbutton;

		@FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div[4]/div[2]/input")
		public WebElement Entermobilenumber;

		@FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div[5]/div[1]/div[2]/input")
		public WebElement Enterpassword;

		@FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div[5]/div[3]")
		public WebElement Loginbutton;

		public WebElement getLogin() {
			return Login;
		}

		public WebElement getMobilenumberbutton() {
			return Mobilenumberbutton;
		}

		public WebElement getEntermobilenumber() {
			return Entermobilenumber;
		}

		public WebElement getEnterpassword() {
			return Enterpassword;
		}

		public WebElement getLoginbutton() {
			return Loginbutton;
		}



}
