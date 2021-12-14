package com.opencart.qa.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementUtils 
{
	public WebDriver driver;
	public JavascriptExecutor js;
	public elementUtils(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "ID":
			locator = By.id(locatorValue);	
			break;
		case "name":
			locator = By.name(locatorValue);	
			break;
		case "classname":
			locator = By.className(locatorValue);	
			break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);	
			break;
		case "xpath":
			locator = By.xpath(locatorValue);	
			break;
		case "linktext":
			locator = By.linkText(locatorValue);	
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);	
			break;
		default:
			System.out.println("Please pass the correct locator");
			break;
		}
		return locator;	
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public WebElement getElement(String locatorType, String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	public List<WebElement> getElements(String locatorType, String locatorValue)
	{
		return driver.findElements(getBy(locatorType, locatorValue));
	}
	
	public void doSendKey(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public void customWait()
	{
		js = (JavascriptExecutor) driver;
		 String status = js.executeScript("return document.readyState;").toString();
		 
		 if(status.equals("completed"))
		 {
			 System.out.println("Page is loaded successfully" +status);
		 }
		 else
		 {
			 for(int i = 1;i<=20;i++)
			 {
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 status = js.executeScript("return document.readyState;").toString();
				 System.out.println("current status is "+status);
				 if(status.equals("complete"))
				 {
					 break;
				 }
			 }
		 }
		
	}

}
