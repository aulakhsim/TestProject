package com.testingwebsite.testCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingwebsite.pageObjects.LoginPage;

public class TC00001 extends BaseClass {
	@Test
	public void loginTest() throws IOException, InterruptedException
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
		
		//String actualTitle = driver.getTitle();
		//String expectedTitle = "Title of Page";
		//assertEquals(expectedTitle,actualTitle);
		
		//Thread.sleep(7000);
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		
		{
			Assert.assertTrue(true);
		}
	else
	{
		captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		Logger.info("Login test failed");
		}
		
	}
	
	

}
