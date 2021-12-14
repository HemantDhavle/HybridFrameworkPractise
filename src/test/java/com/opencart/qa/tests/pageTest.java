package com.opencart.qa.tests;

import org.testng.annotations.Test;

public class pageTest extends baseTest 
{
	@Test
	public void doLoginTest()
	{
	String username  = prop.getProperty("un");
	String password  = prop.getProperty("pw");
	lp.doLogin(username, password);	
	System.out.println("Hemant");
	
	}

}
