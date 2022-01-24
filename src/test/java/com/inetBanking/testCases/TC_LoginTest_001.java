package com.inetBanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UserName);
		log.info("username given");
		lp.setPassword(password);
		log.info("password given");
		lp.clickSubmit();
		log.info("clicked");
		//System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			log.info("testcase failed");
			
		}
		   
	}

}
