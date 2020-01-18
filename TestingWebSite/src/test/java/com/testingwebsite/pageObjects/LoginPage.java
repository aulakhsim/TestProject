package com.testingwebsite.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.testingwebsite.testCase.BaseClass;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(name = "btnLogin")
	WebElement btnsubmit;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement linkLogout;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnsubmit.click();
	}
	
	public void ClickLogout() {
		linkLogout.click();
	}

}
