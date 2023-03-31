package com.tutorialsninja.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pages.AccountSucessPage;
import com.tutorialninja.qa.pages.Homepage;
import com.tutorialninja.qa.pages.Registerpage;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{

	//public WebDriver driver = new ChromeDriver();
	public WebDriver driver;
	Registerpage registerPage;
	AccountSucessPage accountSucessPage;
	
	public RegisterTest() {
		super();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));			//return type of the method is WebDriver so, driver initailization is done

		Homepage homePage = new Homepage(driver);
		registerPage = homePage.navigateToRegisterPage();
		
		/* above line reduce the below 2 lines
		 * homePage.clickOnMyAccount();
		 * registerPage = homePage.selectRegisterOption();
		*/
	}
	
	
	@Test(priority=1)
	public void verifyRegisteringWithMandatorydFields() {
		
		/*
		registerPage.enterfirstName(dataProp.getProperty("firstName"));
		registerPage.enterlastNameField(dataProp.getProperty("lastName"));
		registerPage.enteremailField(Utilities.generateEmailWithTimestamp());
		registerPage.entertelephoneField(dataProp.getProperty("telephoneNumber"));
		registerPage.enterpasswordField(prop.getProperty("validPassword"));
		registerPage.enterconfirmPasswordField(prop.getProperty("validPassword"));
		registerPage.agreePrivacyPolicy();
		accountSucessPage = registerPage.clickcontinueButton();
		String accountSucessHeading = accountSucessPage.retrieveSucessHeading();
		Assert.assertEquals("Account has not been created",accountSucessHeading, dataProp.getProperty("accountSuccessfullyCreated"));
		*/
		
		accountSucessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), 
							Utilities.generateEmailWithTimestamp(), dataProp.getProperty("telephoneNumber"), 
							prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals("Account has not been created",accountSucessPage.retrieveSucessHeading(), dataProp.getProperty("accountSuccessfullyCreated"));

	}
	
	@Test(priority=2)
	public void verifyRegisteringWithAllFields() {

		/*
		registerPage.enterfirstName(dataProp.getProperty("firstName"));
		registerPage.enterlastNameField(dataProp.getProperty("lastName"));
		registerPage.enteremailField(Utilities.generateEmailWithTimestamp());
		registerPage.entertelephoneField(dataProp.getProperty("telephoneNumber"));
		registerPage.enterpasswordField(prop.getProperty("validPassword"));
		registerPage.enterconfirmPasswordField(prop.getProperty("validPassword"));
		registerPage.yesSelectNewsletterOption();
		registerPage.agreePrivacyPolicy();
		accountSucessPage = registerPage.clickcontinueButton();
		
		AccountSucessPage accountSucessPage = new AccountSucessPage(driver);
		String accountSucessHeading = accountSucessPage.retrieveSucessHeading();
		Assert.assertEquals("Account has not been created",accountSucessHeading, dataProp.getProperty("accountSuccessfullyCreated"));
		*/
		
		accountSucessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), 
							Utilities.generateEmailWithTimestamp(), dataProp.getProperty("telephoneNumber"), 
							prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals("Account has not been created",accountSucessPage.retrieveSucessHeading(), dataProp.getProperty("accountSuccessfullyCreated"));
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringWithExistingEmailAddress() {

		/*
		registerPage.enterfirstName(dataProp.getProperty("firstName"));
		registerPage.enterlastNameField(dataProp.getProperty("lastName"));
		registerPage.enteremailField(prop.getProperty("validEmail"));
		registerPage.entertelephoneField(dataProp.getProperty("telephoneNumber"));
		registerPage.enterpasswordField(prop.getProperty("validPassword"));
		registerPage.enterconfirmPasswordField(prop.getProperty("validPassword"));
		registerPage.yesSelectNewsletterOption();
		registerPage.agreePrivacyPolicy();
		registerPage.clickcontinueButton();
		
		String actualWarningMessage = registerPage.retrieveDuplicateEmailWarning();
		Assert.assertTrue(actualWarningMessage.contains(dataProp.getProperty("duplicateEmailWarning")));
		*/
		
		registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), 
				prop.getProperty("validEmail"), prop.getProperty("validEmail"), 
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(registerPage.retrieveDuplicateEmailWarning().contains(dataProp.getProperty("duplicateEmailWarning")));
		
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		registerPage.clickcontinueButton();

		/*
		String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")));
		
		String actualfirstNameWarning = registerPage.retrieveFirstNameWarning();
		Assert.assertEquals(actualfirstNameWarning, dataProp.getProperty("firstNameWarning"));
		
		String actuallastNameWarning = registerPage.retrieveLastNameWarningText();
		Assert.assertEquals(actuallastNameWarning, dataProp.getProperty("lastNameWarning"));
		
		String actualemailWarning = registerPage.retrieveEmailWarning();
		Assert.assertEquals(actualemailWarning, dataProp.getProperty("emailWarning"));
		
		String actualtelephoneWarning = registerPage.retrieveTelephoneWarning();
		Assert.assertEquals(actualtelephoneWarning, dataProp.getProperty("telephoneWarning"));
		
		String actualpasswordWarning = registerPage.retrievePasswordWarning();
		Assert.assertEquals(actualpasswordWarning, dataProp.getProperty("passwordWarning"));
		*/
		
		
		Assert.assertTrue(registerPage.retrievePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")));
		Assert.assertEquals(registerPage.retrieveFirstNameWarning(), dataProp.getProperty("firstNameWarning"));
		Assert.assertEquals(registerPage.retrieveLastNameWarningText(), dataProp.getProperty("lastNameWarning"));
		Assert.assertEquals(registerPage.retrieveEmailWarning(), dataProp.getProperty("emailWarning"));
		Assert.assertEquals(registerPage.retrieveTelephoneWarning(), dataProp.getProperty("telephoneWarning"));
		Assert.assertEquals(registerPage.retrievePasswordWarning(), dataProp.getProperty("passwordWarning"));
		
		
		
		/*
		 * if we want to reduce number of lines: below 1 line can be written, which calls 1 method having all the warning messages
		 * Assert.assertTrue(registerPage.displayStatus(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), 
				dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));
		 */
	}
	

}
