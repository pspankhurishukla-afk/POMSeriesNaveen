package com.qa.openCart.utils;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
private WebDriver driver;

public ElementUtil(WebDriver driver)
{
	this.driver=driver;
}
	
private void nullCheck(String value) 
	{
		if(value==null)
		{
			//throw new ElementException("value is null :" + value);
		}
		}
	By email = By.id("input-email");
	
	
	public void doSendKeys(By locator, String value) {
		nullCheck(value);
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}
	
	

//	public void dosendKeys(By locator, String value, int timeOut)
//	{
//		nullCheck(value);
//		waitForElementVisible(locator, timeOut).clear();
//		// waitForElementVisible(locator, timeOut).sendKeys(value);
//		  waitForElementVisible(locator, timeOut).sendKeys(value);
//	}
//	
	
	public WebElement getElement(By locator) {
		try {
		WebElement element= driver.findElement(locator);
		return element;
		}
		catch(NoSuchElementException e) {
			System.out.println("element is not present on page");
			return null;
		}
}
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	

	
	public String getText(By locator) {
		
	String text=getElement(locator).getText();
		return text;
		
	}
	
	
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	
	
	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
		}
	
		public int getElementCounts(By locator) {
			return getElements(locator).size();
		}
		
		
		public  List<String> getElementTextList(By locator) {
		List<WebElement> listText=  getElements(locator);
		List<String> eleTextList=new ArrayList<String>();
		for(WebElement e : listText)
		{
			
		String textList= e.getText();
			if(textList.length()!=0) {
				
				eleTextList.add(textList);
			}
		}
		
			return eleTextList;
		
	    }

public void getCountryByIndex(By locator, int index)
{
	Select country=new Select(getElement(locator));
	country.selectByIndex(index);
}

public void getEmployeesByValue(By locator, String value)
{
	Select employee=new Select(getElement(locator));
	employee.selectByValue(value);
}

public  void doSearch(By searchField, String searchKey, By suggestions , String value)throws InterruptedException
{
	doSendKeys(searchField, searchKey);
	
	Thread.sleep(3000);
	List<WebElement> suggList = getElements(suggestions);
	for(WebElement e : suggList)
	{  String s= e.getText();
	System.out.println(s);
		if(s.contains(value))
		{
		e.click();
		break;
		}
	}
}


public boolean elementIsDisplayed(By locator) {
	try {
		
	boolean flag=driver.findElement(locator).isDisplayed();
    System.out.println("element is displayed : " +locator);
    return flag;
	}
catch(NoSuchElementException e)
	{
	System.out.println("element displayed is not correct: " + locator);	
	return false;
	}
}



//    **************************wait.util***********************************
/**
 * 
 * @param locator
 * @param timeOut
 * @return
 */
public  WebElement waitForElementPresence(By locator, int timeOut)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
}
/**
 * 
 * @param locator
 * @param timeOut
 * @return
 */

public  List<WebElement> waitForElementVisible(By locator, int timeOut)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	try {
	return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	catch(Exception e)
	{
		return List.of(); //return empty list
	}
	
}

public void clickWhenReady(By locator, int timeOut)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}
                       


      public String waitForTitleToBe(String titleValue,int timeOut) throws TimeoutException
     {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if(wait.until(ExpectedConditions.titleIs(titleValue)))
	{
		return driver.getTitle();
	}
	return driver.getTitle();
	}
      
      
        public String waitForURLContains(String urlFraction, int timeOut) throws TimeoutException {
  		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

  		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
  		return driver.getCurrentUrl();
  	}
}
