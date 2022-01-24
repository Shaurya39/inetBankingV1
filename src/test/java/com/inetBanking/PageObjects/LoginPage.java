package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup         //This attribute helps scripts to instruct the InitElements method to cache the element once it's located. ... It means the elements of the page will be cached once searched
	WebElement UserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pass;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement log;
	
	@FindBy(css = "a[href='Logout.php']")
	@CacheLookup
	WebElement logout;
	
	public void setUserName(String uName)    //action method created for UserName
	{
		UserName.sendKeys(uName);
	}
	
	public void setPassword(String pword)    //action method created for password
	{
		pass.sendKeys(pword);
	}
	
	public void clickSubmit()    //action method created for login btn
	{
		log.click();
	}
	public void logout()    //action method created for logout btn
	{
		logout.click();
	}
	
	

}
