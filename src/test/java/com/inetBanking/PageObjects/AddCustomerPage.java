package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.CSS, using="a[href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement custName;
	
	@FindBy(how = How.CSS, using="input[name=rad1]:nth-child(2)")
	@CacheLookup
	WebElement gender;
	
	@FindBy(how = How.CSS, using="#dob")
	@CacheLookup
	WebElement dob;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement pin;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement phoneno;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement emailid;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement submit;
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	public void custName(String name)
	{
		custName.sendKeys(name);
	}
	public void selectGender()
	{
		gender.click();
	}
	public void selectdob(String dd, String mm, String yyyy)
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	public void fillAddress(String add)
	{
		address.sendKeys(add);
	}
	public void fillCity(String ci)
	{
		city.sendKeys(ci);
	}
	public void fillState(String sta)
	{
		state.sendKeys("sta");
	}
	public void fillPin(int pi)
	{
		pin.sendKeys(String.valueOf(pi));
		
	}
	public void fillPhone(String ph)
	{
		phoneno.sendKeys(ph);
	}
	public void fillEmail(String mail)
	{
		emailid.sendKeys(mail);
	}
	public void fillPassword(String ps)
	{
		state.sendKeys(ps);
	}
	public void submit()
	{
		submit.click();
	}
	
	
	
	
	

}
