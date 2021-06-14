package com.unifyautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unifyautomation.base.BaseClass;

public class LaunchpadPage extends BaseClass {

	@FindBy(xpath="//img[@id='rmUnifyLogo']")
	WebElement launchpadLogo;
	
	@FindBy(xpath="//span[contains(text(),'Management Console')]")
	WebElement managementConsoleLink;
	
	@FindBy(xpath="//span[contains(text(),'App Library')]")
	WebElement appLibraryLink;
	
	
	
	public LaunchpadPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLaunchpadLogoVisible()
	{
		boolean isLogoAvaialble = launchpadLogo.isDisplayed();
		return isLogoAvaialble;
	}
	
	public boolean isAppLibrayAndManagementConsoleLinksAvailable()
	{
		if(appLibraryLink.isDisplayed() && managementConsoleLink.isDisplayed())
		{
		    return true;
		 }
	else
		{
			return false;
		}
		
	}
	
	
}
