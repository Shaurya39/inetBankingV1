package com.inetBanking.testCases;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC_AddCustomerTest_003 extends BaseClass {
  
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UserName);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		log.info("providing customer info");
		addcust.custName("abcd");
		addcust.selectGender();
		addcust.selectdob("09","07", "1998");
		Thread.sleep(3000);
		addcust.fillAddress("India");
		addcust.fillCity("hyd");
		addcust.fillState("AP");
		addcust.fillPin(6789);
		addcust.fillPhone("56789");
		String email = randomString()+"@gmail.com";
		addcust.fillEmail(email);
		addcust.fillPassword("abcdef");
		addcust.submit();
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("Testcase passed");;
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			log.info("Testcase failed");;
		}
	}
	
	
}
