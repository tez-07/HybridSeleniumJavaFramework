package com.tutorialsninja.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.pages.Homepage;
import com.tutorialninja.qa.pages.Searchpage;
import com.tutorialsninja.qa.base.Base;

public class SearchTest extends Base{

	public WebDriver driver;
	Searchpage searchPage;
	Homepage homePage;
	
	public SearchTest() {
		super();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new Homepage(driver);
	}
	
	@Test(priority=1)
	public void verifySearchingWithValidProduct() {
		
		/*
		 * homePage.enterSearch(dataProp.getProperty("validProduct"));
		 * searchPage = homePage.clickOnSearchButton();
		*/
		
		searchPage = homePage.searchforProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue("Valid product isn't displayed",searchPage.displayHPValidProduct());

	}
	
	@Test(priority=2)
	public void verifySearchingWithInvalidProduct() {
		
		/*
		homePage.enterSearch(dataProp.getProperty("invalidProduct"));
		searchPage = homePage.clickOnSearchButton();
		*/
		
		searchPage = homePage.searchforProduct(dataProp.getProperty("invalidProduct"));
		//Correct Code
		//Assert.assertEquals(searchPage.retrieveNoProductMessage(), dataProp.getProperty("noProductInSearchResult"));
		
		//Incorrect Code -- Not working so, running it as correct
		Assert.assertEquals(searchPage.retrieveNoProductMessage(), dataProp.getProperty("noProductInSearchResult"));
	}
	

	@Test(priority=3, dependsOnMethods={"verifySearchingWithInvalidProduct"})
	public void verifySearchingWithoutAnyProducts() {
		
		
		searchPage = homePage.clickOnSearchButton();
		
		String actualSearchMessage = searchPage.retrieveNoProductMessage();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductInSearchResult"));
		
	}
}
