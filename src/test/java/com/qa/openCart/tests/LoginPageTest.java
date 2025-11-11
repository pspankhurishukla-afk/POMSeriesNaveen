package com.qa.openCart.tests;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.openCart.base.BaseTest;
import com.qa.openCart.constant.AppConstants;
import com.qa.openCart.errors.AppErrors;

public class LoginPageTest extends BaseTest {

	
	@Test(priority=1)
	public void loginPageTitleTest() throws TimeoutException {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle ,AppConstants.LOGIN_PAGE_TITLE, AppErrors.BROWSER_NOT_FOUND);
	}
	
	
	@Test(priority=2)
	public void checkPwdLinkExist() {
		Assert.assertTrue(loginPage.checkPwdLinkExist());
	}
	
	@Test(priority=3)
	public void loginClick() throws TimeoutException {
		accPage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	Assert.assertEquals(accPage.getAccPageTitle() ,AppConstants.ACCOUNT_PAGE_TITLE, AppErrors.TITLE_NOT_FOUND);
	}
	
	
	
	
}
