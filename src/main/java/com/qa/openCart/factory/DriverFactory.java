package com.qa.openCart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.openCart.constant.AppConstants;
import com.qa.openCart.errors.AppErrors;
import com.qa.openCart.exceptions.BrowserException;

public class DriverFactory {
	WebDriver driver;
	 Properties prop;

	/**
	 * This is used to initialize the driver on the basis of browser.
	 * @param BrowserName
	 */
	public WebDriver initDriver(Properties prop)
	
	{ 
		String BrowserName=prop.getProperty("browser");
	
	
		System.out.println("broswer name is :" +BrowserName);
		switch (BrowserName) {
		case "chrome":
			driver=new ChromeDriver();
			System.out.println("chrome driver");
			break;
		case "firefox":
			driver=new FirefoxDriver();
			System.out.println("firefox driver");
			break;
		case "edge":
			driver=new EdgeDriver();
			System.out.println("edge driver");
			break;

		default:
			System.out.println("incorrect browser");
			throw new BrowserException(AppErrors.BROWSER_NOT_FOUND);
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	/**
	 * This method is used to initialize the property from prop file(config.properties)
	 * @return This return properties file
	 */
	public Properties initProp()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(AppConstants.CONFIG_FILE_PATH);
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		return prop;
	}
	
}
