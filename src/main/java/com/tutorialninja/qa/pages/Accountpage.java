package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {

	WebDriver driver;
	
	//Objects
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	public Accountpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public boolean getDisplayStatusofEditYourAccountInformation() {
		boolean displayStatus = editYourAccountInformationOption.isDisplayed();
		return displayStatus;
	}
}

