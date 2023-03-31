package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

	WebDriver driver;
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement firstNameField;

	@FindBy(id="input-lastname")
	private WebElement lastNameField;

	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning; 
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public Registerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions	
	public void enterfirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void enterlastNameField(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enteremailField(String email) {
		emailField.sendKeys(email);
	}
		
	public void entertelephoneField(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void enterpasswordField(String password) {
		passwordField.sendKeys(password);
	}
		
	public void enterconfirmPasswordField(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void agreePrivacyPolicy() {
		privacyPolicyField.click();
	}
	
	public AccountSucessPage clickcontinueButton() {
		continueButton.click();
		return new AccountSucessPage(driver);
	}
	
	public void yesSelectNewsletterOption() {
		yesNewsletterOption.click();
	}
	
	public String retrieveDuplicateEmailWarning() {
		String duplicateWarningText = duplicateEmailWarning.getText();
		return duplicateWarningText;
	}
	
	public String retrievePrivacyPolicyWarning() {
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String retrieveFirstNameWarning() {
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrieveLastNameWarningText() {
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveEmailWarning() {
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrieveTelephoneWarning() {
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrievePasswordWarning() {
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	
	//combining all methods
	public AccountSucessPage registerWithMandatoryFields(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSucessPage(driver);
	}
	
	
	public AccountSucessPage registerWithAllFields(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		privacyPolicyField.click();
		yesNewsletterOption.click();
		continueButton.click();
		return new AccountSucessPage(driver);
	}
	
	
	
	
	
	// Issue: Will not provide the exact line where the code is failing; but will reduce number of lines
	public boolean displayStatus(String expectedPrivacyPolicyWarning, String expectedfirstNameWarning, String expectedLastNameWarning, 
			String expectedEmailWarning, String expectedTelephoneWarning, String expectedpasswordWarning) {
		
		String actualPrivacyPolicyWarningText = privacyPolicyWarning.getText();
		boolean privacyPolicyStatus = actualPrivacyPolicyWarningText.contains(expectedPrivacyPolicyWarning);
		
		String actualFirstNameWarningText = firstNameWarning.getText();
		boolean firstNameStatus = actualFirstNameWarningText.contains(actualFirstNameWarningText);
		
		String actualLastNameWarningText = lastNameWarning.getText();
		boolean lastNameStatus = actualLastNameWarningText.contains(actualLastNameWarningText);
		
		String actualEmailWarningText = emailWarning.getText();
		boolean emailStatus = actualEmailWarningText.contains(actualEmailWarningText);
		
		String actualTelephoneWarningText = telephoneWarning.getText();
		boolean telephoneStatus = actualTelephoneWarningText.contains(actualTelephoneWarningText);
		
		String actualPasswordWarningText = passwordWarning.getText();
		boolean passwordStatus = actualPasswordWarningText.contains(actualPasswordWarningText);
		
		
		return privacyPolicyStatus && firstNameStatus && lastNameStatus && emailStatus && telephoneStatus && passwordStatus;
	}
}
