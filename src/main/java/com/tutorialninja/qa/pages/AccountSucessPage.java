package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement AccountSuccessPage;
	
	public AccountSucessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String retrieveSucessHeading() {
		String accountSucessPageHeadingText = AccountSuccessPage.getText();
		return accountSucessPageHeadingText;
	}
}
