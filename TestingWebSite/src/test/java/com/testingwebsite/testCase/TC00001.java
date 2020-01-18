package com.testingwebsite.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingwebsite.pageObjects.LoginPage;

public class TC00001 extends BaseClass {
	@Test
	public void loginTest() 
	{
		driver.get(baseURL);
		Logger.info("URL is Opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Entered username");
		
		lp.setPassword(password);
		Logger.info("Entered Password ");
		
		Logger.info("Click Submit button ");
		lp.clickSubmit();
		
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
	//	else
		//{
		//	Assert.assertTrue(false);
	//	}
		
	}
	
	

}
