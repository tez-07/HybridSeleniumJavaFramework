 package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pages.Accountpage;
import com.tutorialninja.qa.pages.Homepage;
import com.tutorialninja.qa.pages.Loginpage;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{

	Loginpage loginPage;
	Accountpage accountPage;
	
	public LoginTest() {
		super();
	}
	
	//WebDriver driver = new ChromeDriver();
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		/*
		 * loadPropertiesFile(); 
		 * calling the method is not used in this framework as we converted the same method to constructor
		 * public Login() {super();}  here we are calling the parent class constructor
		 */
		
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));			//hard coding is removed
		Homepage homePage = new Homepage(driver);
		loginPage = homePage.navigateToLoginpage();
		
		/* combining these two lines in one method
		 *homePage.clickOnMyAccount();
		 *loginPage = homePage.selectLoginOption();		
		*/
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	// hard coding is removed as now retrieving data from excel using method created in utilities class
	@DataProvider(name="testData")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
//  Valid Email & Valid Password	
	@Test(priority = 1, dataProvider="testData")
	public void verifyLoginWithValidCredentials(String email, String password) {	
		
		/*
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		accountPage = loginPage.clickOnLoginButton(); 		
		*/
		
		accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusofEditYourAccountInformation(), "Edit your account is information is not present");
	}
	
	
//  Invalid Credentials
	@Test(priority = 2)
	public void verifyLoginwithInvalidCredentials() {
		
		
		/*loginPage.enterEmailAddress(Utilities.generateEmailWithTimestamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Warning message is not displayed");
		*/
		
		loginPage.login(Utilities.generateEmailWithTimestamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatch")), 
				"Warning message is not displayed");
		
	}
	
	
//	Invalid Email & Valid Password
	@Test(priority= 3)
	public void verifyLoginwithInvalidEmailandValidPassword() {
		
		/*
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimestamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesaage = dataProp.getProperty("emailPasswordNoMatch");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesaage), "Warning message is not displayed");
		*/
		
		//above lines are reduced to 2 lines
		loginPage.login(Utilities.generateEmailWithTimestamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatch")), 
				"Warning message is not displayed");
		
	}
	
	
//  Valid Email & Invalid Password	
	@Test(priority = 4)
	public void verifyLoginWithValidEmailandInvalidPassword() {
		
		/*
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesaage = dataProp.getProperty("emailPasswordNoMatch");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesaage), "Warning message is not displayed");
		
		*/
		
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatch")), 
				"Warning message is not displayed");
		
		
	}
	
	
//  Without Credentials		
	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {
		
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatch")), 
				"Warning message is not displayed");
		
		/*
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessage();
		String expectedWarningMesaage = dataProp.getProperty("emailPasswordNoMatch");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMesaage), "Warning message is not displayed");
		*/
	}

	
}
