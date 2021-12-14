package com.opencart.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.opencart.qa.factory.driverFactory;
import com.opencart.qa.pages.LoginPage;

public class baseTest 
{
	driverFactory df;
	WebDriver driver;
	Properties prop;
	LoginPage lp;
	
	@BeforeTest
	public void setUp()
	{
		df  = new driverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}

}
