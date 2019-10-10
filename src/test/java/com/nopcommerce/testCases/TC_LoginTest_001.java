package com.nopcommerce.testCases;

// this is my Login Test...................

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("***************  Starting TC_LoginTest_001 **************");
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("***************  Providing Login details **************");
		
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		logger.info("*************** Verifying Login **************");
		
		if(exp_title.equals(act_title))
		{
			logger.info("**************** loginTest is Passed ************* ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("**************** loginTest is Failed ************* ");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);

		}
		logger.info("***************  Ending TC_LoginTest_001 **************");
	}
	
	
}
