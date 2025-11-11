package com.qa.openCart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.openCart.factory.DriverFactory;
import com.qa.openCart.pages.AccountsPage;
import com.qa.openCart.pages.LoginPage;
import com.qa.openCart.pages.ProductInfoPage;
import com.qa.openCart.pages.SearchResultsPage;

public class BaseTest {
	
	DriverFactory df;
	protected Properties prop;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResultPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;
	
	@BeforeTest
	public void setUp()
	{
		df= new DriverFactory();
	prop=	df.initProp();
	driver=	df.initDriver(prop);
	loginPage=new LoginPage(driver);
	softAssert=new SoftAssert();
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

