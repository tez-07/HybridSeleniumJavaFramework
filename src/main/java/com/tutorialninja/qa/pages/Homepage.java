package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;							//
		PageFactory.initElements(driver, this);			// PageFactory line which will initializes all WebElements defined in the current (POM) class
	}
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public Loginpage selectLoginOption() {
		loginOption.click();
		return new Loginpage(driver);					// directly creating object of login page in the method itself
	}
	
	//combining clickOnMyAccount & selectLoginOption
	public Loginpage navigateToLoginpage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new Loginpage(driver);
	}
	
	
	
	public Registerpage selectRegisterOption() {
		registerOption.click();
		return new Registerpage(driver);
	}
	
	//Direct Register page method
	public Registerpage navigateToRegisterPage() {
		myAccountDropMenu.click();
		registerOption.click();
		return new Registerpage(driver);
	}
	
	public void enterSearch(String productText) {
		searchBoxField.sendKeys(productText);
	}
	
	public Searchpage clickOnSearchButton() {
		searchButton.click();
		return new Searchpage(driver);
	}
	
	//combination for searchPage
	public Searchpage searchforProduct(String productText) {
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new Searchpage(driver);
	}
	
}
