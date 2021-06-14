package com.unifyautomation.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.unifyautomation.base.BaseClass;
import com.unifyautomation.pages.LaunchpadPage;
import com.unifyautomation.pages.LoginPage;
import com.unifyautomation.utilities.TestUtil;
import com.unifyautomation.utilities.XLUtility;

public class UnifyLoginTest extends BaseClass {
	
	public LoginPage loginpage;
	public LaunchpadPage launchpadpage;
	public XLUtility xlutility;
	String sheetName = "Sheet1";
	public UnifyLoginTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		BaseClass.intialization();
		loginpage = new LoginPage();	
	}
	
	@Test(dataProvider="LoginData" , priority=1)
	public void verifyValidAndInvalidLogin(String user , String pass ,String credential)
	
	{
		launchpadpage=loginpage.loginToUnify(user, pass, credential);
		if(credential.equals("valid"))
		{
			if(loginpage.isLaunchpadVisible() == true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if (credential.equals("invalid"))
		{
			if(loginpage.isSignInErrorMessageVisibile() == true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
			
	}
	@DataProvider(name="LoginData")
	public  Object[][] getLoginTestdata() throws IOException
	
	{
		Object[][] loginData=TestUtil.gettestData(sheetName);
		return loginData;
	}
	
	
	@Test( priority=2)
	public void verifyBrandServiceStatusLogo()
	{
		Assert.assertTrue(loginpage.isBrandAndSeviceStatusLogoDisplayed());
	}
	
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	
	
}

