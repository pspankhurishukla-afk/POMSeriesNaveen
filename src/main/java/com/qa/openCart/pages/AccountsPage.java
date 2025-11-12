package com.qa.openCart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openCart.constant.AppConstants;
import com.qa.openCart.utils.ElementUtil;
import com.qa.openCart.utils.TimeUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil =new ElementUtil(driver);
	}
	
	
	
	private By logoutLink = By.linkText("Logout");
	private By headers =By.cssSelector("div#content h2");
	private By search=By.name("search");
	private By searchIcon=By.cssSelector("div#search button");

	
	public String getAccPageTitle() throws TimeoutException
	{
		String title=eleUtil.waitForTitleToBe(AppConstants.ACCOUNT_PAGE_TITLE, TimeUtil.DEFAULT_TIME);
		
		System.out.println(" login page title : " +title);
		return title;
	}
	
	public String getAccPageUrl() throws TimeoutException
	{
		String URL=eleUtil.waitForURLContains(AppConstants.ACCOUNT_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME);
		System.out.println(" Account page URL : " +URL);
		return URL;
	}
	
	public boolean isLogoutLinkExit() {
		return eleUtil.elementIsDisplayed(logoutLink);
		
		
	//return driver.findElement(logoutLink).isDisplayed();
	}
	
	public boolean isSearchExit()
	{
		return driver.findElement(search).isDisplayed();
	}
	
	
	public List<String> getAccPageHeaders()
	{
		System.out.println("Testing");
		List<WebElement> headersList =driver.findElements(headers);
		List<String> headerValueList =new ArrayList<String>();
		for(WebElement e :headersList)
		{
		String text=e.getText();
		headerValueList.add(text);
		}
		return headerValueList;
		
	}
	
	public SearchResultsPage doSearchKey(String searchKey)
	{
		System.out.println("searching :" +searchKey);
		if(isSearchExit())
		{    
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchResultsPage(driver);
		}
		else
		{
			System.out.println("search field is not present on the page");
		}
		return null;
	}
	
	
	
	
	
	
}
