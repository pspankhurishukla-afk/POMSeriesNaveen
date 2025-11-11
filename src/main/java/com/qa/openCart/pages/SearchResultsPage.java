package com.qa.openCart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openCart.utils.ElementUtil;
import com.qa.openCart.utils.TimeUtil;

public class SearchResultsPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By searchResult=By.cssSelector("div.product-thumb");
	
	
	public SearchResultsPage(WebDriver driver) 
	{
		this.driver=driver;
		eleUtil =new ElementUtil(driver);
	}
    
	public int searchProductCount()
	{ 
		
 List<WebElement> resultList= eleUtil.waitForElementVisible(searchResult, TimeUtil.DEFAULT_TIME);
				int resultCount =resultList.size();
		System.out.println("product result count :" +resultCount);
	return	resultCount;
	}
	
	
	
	public ProductInfoPage searchProduct(String productName)
	{
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
}
