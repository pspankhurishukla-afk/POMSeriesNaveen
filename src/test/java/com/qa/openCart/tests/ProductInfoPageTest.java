package com.qa.openCart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;
import com.qa.openCart.errors.AppErrors;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	public void productInfoPageSetup()
	{ accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@DataProvider
	public Object[][] getSearchData()
	{
		return new Object[][]
				{
		{"macbook","macbook Pro"},
		{"imac","iMac"},
		};
	}

	
	@Test(dataProvider="getSearchData")
     
     public void productHeaderTest(String searchKey, String productName) {
    	 searchResultPage= accPage.doSearchKey(searchKey);
    	 productInfoPage=searchResultPage.searchProduct(productName);
    	 Assert.assertEquals(productInfoPage.getProductHeader(), productName,AppErrors.HEADER_NOT_FOUND);
     }
	@DataProvider
	public Object[][] getProductImageData()
	{
		return new Object[][]
				{
		{"macbook","macbook Pro",4},
		{"imac","iMac",3},
		};
	}

	
	@Test(dataProvider="getProductImageData")
     public void productImageCountTest(String searchKey, String productName,int imageCount) {
    	 searchResultPage= accPage.doSearchKey(searchKey);
    	 productInfoPage=searchResultPage.searchProduct(productName);
    	Assert.assertEquals(productInfoPage.getProductImageCount(),imageCount, AppErrors.PRODUCT_IMAGE_COUNT_MISMATCHED);
     }
	
	@Test
	public void productInfoPage() {
		searchResultPage=accPage.doSearchKey("imac");
		productInfoPage=searchResultPage.searchProduct("iMac");
	Map<String, String> productInfoMap=	productInfoPage.getProductInfoMap();
	System.out.println("product info");
	System.out.println(productInfoMap);
	softAssert.assertEquals(productInfoMap.get("productName"),"imac");
	softAssert.assertEquals(productInfoMap.get("productHeader"),"iMac");
	softAssert.assertAll();
	System.out.println("testing is done");
	
	}
}
