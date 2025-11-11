package com.qa.openCart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.openCart.utils.ElementUtil;
import com.qa.openCart.utils.TimeUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By productHeader= By.cssSelector("div#content h1");
	private By productImageCount = By.cssSelector("div#content a.thumbnail");
	private By productMetaData =By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData =By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private HashMap<String, String> productMap ;
	
	public Map<String, String> getProductInfoMap() {
		productMap = new HashMap<String, String>();
		productMap.put("productName", getProductHeader());
		productMap.put("productImageCount", String.valueOf(getProductImageCount()));
		getProductMetaData();
		getproductPriceData();
		return productMap;
		
	}
	
	public ProductInfoPage(WebDriver driver) 
	{
		this.driver=driver;
		eleUtil =new ElementUtil(driver);
	}
	
	public String getProductHeader()
	{
		String header=eleUtil.doGetText(productHeader);
		System.out.println("get product header :" +header);
		return header;
	}
	
	public int getProductImageCount() {
		int imageCount= eleUtil.waitForElementVisible(productImageCount , TimeUtil.DEFAULT_TIME).size();
		System.out.println("get image count :"+ imageCount);
		return imageCount;
	}
	
	private void getProductMetaData() {
		productMap = new HashMap<String, String>();
		List<WebElement> metaList= eleUtil.getElements(productMetaData);
		for(WebElement e : metaList)
		{
			String metaData =e.getText();
			String meta[]=metaData.split(":") ;
			String metaKey =meta[0];
			String metaValue =meta[1].trim();
			productMap.put(metaKey, metaValue);
		}
	}
		private void getproductPriceData() {
			productMap = new HashMap<String, String>();
			List<WebElement> priceList =eleUtil.getElements(productPriceData);
			String priceValue =priceList.get(0).getText();
			String exTaxPrice =priceList.get(1).getText().split(":")[1].trim();
			productMap.put("priceValue", priceValue);
			productMap.put("exTaxPrice", exTaxPrice);
		}
			
		
	}

