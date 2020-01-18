package com.testingwebsite.testCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.testingwebsite.uilities.ReadConfig;


public class BaseClass {
	// create object of read config
	ReadConfig readconfig=new ReadConfig();
	
	
	public String baseURL= readconfig.getURL();
	public String username= readconfig.getUserName();
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		
		 Logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	@AfterClass
	public void tearDown(){
		
		driver.quit();
	}

}
