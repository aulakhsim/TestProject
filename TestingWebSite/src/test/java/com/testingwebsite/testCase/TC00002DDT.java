package com.testingwebsite.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testingwebsite.pageObjects.LoginPage;
import com.testingwebsite.uilities.XLUtils;

public class TC00002DDT extends BaseClass
{
   @Test(dataProvider="LoginData")
   public void loginDDT(String user, String pwd) 
   {
	   LoginPage lp=new LoginPage(driver);
	   lp.setUserName(user);
	   Logger.info("username is added");
	   lp.setPassword(pwd);
	   Logger.info("Password is provided");
	   lp.clickSubmit();
	   
	   if(AlertPreasent()==true)
	   {
		   driver.switchTo().alert().accept();
		   driver.switchTo().defaultContent();
		   Assert.assertTrue(false);
		   Logger.warn("login failed");
	   }
	   else
	   {
		   Assert.assertTrue(true);
		   Logger.info("Login passed");
		   lp.ClickLogout();
		   driver.switchTo().alert().accept();//close logout alert
		   driver.switchTo().defaultContent();
	   }
   }
   
   
   public boolean AlertPreasent()
   {
	   try
	   {
	   driver.switchTo().alert();
	   return true;
	   }
	   catch(Exception e)
	   {
		   return false;
	   }
   }
   
   
   
   
   @DataProvider(name="LoginData")
   String [][] getData() throws IOException
   {
	   String path="C:/Users/aulak/Desktop/LoginData.xlsx";
	   int rownum=XLUtils.getRowCount(path, "Sheet1");
	   int cocount=XLUtils.getCellCount(path, "Sheet1", 1);
	   
	   String logindata[][]= new String [rownum][cocount];
	   
	   for(int i=1; i<=rownum;i++)
	   {
		   for(int j=0; j<cocount;j++)
		   {
			   logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		   }
	   }
	   return logindata;
   }

}
