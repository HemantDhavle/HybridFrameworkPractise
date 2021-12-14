package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.opencart.qa.utilities.elementUtils;

public class LoginPage
{
	private WebDriver driver;
	elementUtils el;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	private By username = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name='password']");
	private By loginbtn = By.xpath("//input[@value='Login']");
	
	public void doLogin(String un, String pw) 
	{
		el  = new elementUtils(driver);
		System.out.println("entered user name is "+un);
		el.doSendKey(username, un);
		System.out.println("entered password is "+pw);
		el.doSendKey(password, pw);
		driver.findElement(loginbtn).click();
		System.out.println("User successfully clicked on login button");
	}

}
