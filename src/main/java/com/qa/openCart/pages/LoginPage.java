package com.qa.openCart.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.openCart.constant.AppConstants;
import com.qa.openCart.utils.ElementUtil;
import com.qa.openCart.utils.TimeUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

//	1. Page Objects :By locator
	
	private By email_Id= By.id("input-email");
	private By password= By.id("input-password");
	private By loginBtn= By.xpath("//input[@value='Login']");
	private By forgotPwdLink= By.linkText("Forgotten Password");
	
	
	
	
	//2. public constructor of the page
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	//3. public page action/methods
	
	public String getLoginPageTitle() throws TimeoutException
	{   
		
		String title=eleUtil.waitForTitleToBe(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME);
		System.out.println(" login page title : " +title);
		return title;
	}
	
	public String getCurrentURL()
	{
		String URL=driver.getCurrentUrl();
		System.out.println(" login page title : " +URL);
		return URL;
	}
	
	public boolean checkPwdLinkExist()
	{
		//return driver.findElement(forgotPwdLink).isDisplayed();
	return	eleUtil.elementIsDisplayed(forgotPwdLink);
	}
	
	
	public AccountsPage doLogin(String username , String Password)
	{
		
		
		eleUtil.doSendKeys(email_Id, username);
		eleUtil.doSendKeys(password, Password);
		eleUtil.doClick(loginBtn);
		
		
		return new AccountsPage(driver);
	}

	

	
	
	
}
