package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		driver.get(configPropObj.getProperty("baseURL"));
		LoginPage lp=new LoginPage(driver);
		
		logger.info("***************  Providing Login details **************");
		lp.setUserName(configPropObj.getProperty("useremail"));
		lp.setPassword(configPropObj.getProperty("password"));
		lp.clickLogin();
		
		logger.info("***************   TC_AddCustomerTest_003 statred  *********** ");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		
		String emailID=randomestring()+"@gmail.com";
			
		addcust.setEmail(emailID);
		addcust.setPassword("test123");
		addcust.setCustomerRoles("Guest");
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setGender("Male");
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();
		
		//validation
		String msg=driver.findElement(By.tagName("Body")).getText();
		
		if (msg.contains("The new customer has been added successfully")) {
			logger.info("***************  Customer added succesfully *********** ");
			Assert.assertTrue(true);

		} else {
			logger.error("*************** Customer Not added succesfully *********** ");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

		logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
	}
}