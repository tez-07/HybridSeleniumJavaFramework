package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() {														//change from loadPropertiesFile to constructor
		
		prop = new Properties(); 
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties"); 
		
		try {
		FileInputStream file = new FileInputStream(propfile);
		prop.load(file);} 												//loading the config.properties file
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		

		dataProp = new Properties();
		File dataPropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream file1 = new FileInputStream(dataPropfile);
			dataProp.load(file1);
		}catch(Throwable e) {
			e.printStackTrace();	
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));		//hard coding of url is removed by implementing the loadPropertiesFile method
		
		return driver;
	}
}
