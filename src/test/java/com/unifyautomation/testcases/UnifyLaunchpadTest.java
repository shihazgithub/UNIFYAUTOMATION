package com.unifyautomation.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.unifyautomation.base.BaseClass;
import com.unifyautomation.pages.LaunchpadPage;
import com.unifyautomation.pages.LoginPage;
import org.testng.Assert;

public class UnifyLaunchpadTest extends BaseClass {
	LoginPage loginpage ;
	LaunchpadPage launchpadpage;
	
	public UnifyLaunchpadTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		intialization();
		loginpage= new LoginPage();
		launchpadpage=loginpage.loginToUnify(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyLaunchpadLogo()
	{
		Assert.assertTrue(launchpadpage.isLaunchpadLogoVisible(),"Launchpad Logo is not visible");
	}
	
	@Test(priority=2)
	public void verifyAppLibraryManagementConsoleLinks()
	
	{
		Assert.assertTrue(launchpadpage.isAppLibrayAndManagementConsoleLinksAvailable());
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
