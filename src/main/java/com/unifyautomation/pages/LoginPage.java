package com.unifyautomation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unifyautomation.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath="//img[@class='title-brandLogo']")
	WebElement loginpageTitle;
	
	@FindBy(xpath="//input[@id='username2Txt']")
	WebElement usernameTextBox;
	
	@FindBy(xpath="//input[@id='passwordTxt']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='Submit']")
	WebElement submit;
		
	@FindBy(xpath="//span[contains(text(),'Launch Pad')]")
	WebElement launchPad;
	
	@FindBy(xpath="//img[@class='title-brandLogo']")
	WebElement brandLogo;
	
	@FindBy(xpath="//a[@data-original-title='Service Status']")
	WebElement serviceStatusLogo;
	
	@FindBy(xpath="//*[@id='SignInErrorMessage']")
	WebElement signInErrorMessage;;
	
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LaunchpadPage loginToUnify(String username , String password)
	{
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		submit.click();
		return new LaunchpadPage();
	}
	
	public LaunchpadPage loginToUnify(String username , String password , String res)
	{
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		submit.click();
		return new LaunchpadPage();
	}
	
	public boolean  isLaunchpadVisible()
	{
		try {
			
		
		launchPad.isDisplayed();
		return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
	
	public boolean  isSignInErrorMessageVisibile()
	{
		if(signInErrorMessage.isDisplayed() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isBrandAndSeviceStatusLogoDisplayed()
	{
		
		if (brandLogo.isDisplayed() && serviceStatusLogo.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
}
