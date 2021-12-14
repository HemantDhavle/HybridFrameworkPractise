package com.opencart.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory 
{
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop)
	{
		String browserName= prop.getProperty("browser");
		System.out.println("Browser selected is "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Incorrect browser is selected "+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().window().fullscreen();
		return driver;
		
	}
	
	public Properties init_prop()
	{
		 prop = new Properties();
		 try {
			FileInputStream fs = new FileInputStream("./src/test/resources/config/configuration.properties");
			try {
				prop.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
	}
	
}
