package com.qa.openCart.tests;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;
import com.qa.openCart.constant.AppConstants;
import com.qa.openCart.errors.AppErrors;



public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accSetUp() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test
	public void accPageTitle() throws TimeoutException
	{
		
		Assert.assertEquals(accPage.getAccPageTitle(),AppConstants.ACCOUNT_PAGE_TITLE,AppErrors.TITLE_NOT_FOUND );
	}
	
	@Test
	public void accPageUrl() throws TimeoutException
	{
		
		Assert.assertTrue(accPage.getAccPageUrl().contains(AppConstants.ACCOUNT_PAGE_FRACTION_URL),AppErrors.URL_NOT_FOUND );
	}
	
	@Test
	public void accPageHeadersList()
	{
	List<String> accPageHeaderList=	accPage.getAccPageHeaders();
	Assert.assertEquals(accPageHeaderList, AppConstants.ACC_PAGE_HEADERS_LIST, AppConstants.LIST_NOT_MATCHED);
	}
	
	
	@DataProvider
	public Object[][] getSearchData()
	{
		return new Object[][]
				{
		{"macbook",3},
		{"imac",1},
		{"samsung",2}
		
		};
	}

	
	@Test(dataProvider="getSearchData")
	public void doSearch(String searchKey, int resultCount) 
	{
		searchResultPage=accPage.doSearchKey(searchKey);
		
		Assert.assertEquals(searchResultPage.searchProductCount(),resultCount,AppErrors.Result_COUNT_MISMATCHED);
	}
}
