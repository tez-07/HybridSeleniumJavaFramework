package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	
	//Objects
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNoMatch;
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterEmailAddress(String emailText) {
		emailAddress.sendKeys(emailText);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public Accountpage clickOnLoginButton() {
		loginButton.click();
		return new Accountpage(driver);
	}
	
	//single method for Login combining the enterEmailAddress; enterPassword & clickOnLoginButton
	public Accountpage login(String emailText,String password) {
		emailAddress.sendKeys(emailText);
		passwordField.sendKeys(password);
		loginButton.click();
		return new Accountpage(driver);
	}
	
	
	public String retrieveEmailPasswordNotMatchingWarningMessage() {
		String emailPasswordNoMatchText = emailPasswordNoMatch.getText();
		return emailPasswordNoMatchText;
	}
}
