package com.qa.openCart.constant;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	
	private AppConstants() {} //so that no one can create object of this 
	
	public static final String CONFIG_FILE_PATH = "./scr/test/resources/config/config.properties";
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String ACCOUNT_PAGE_TITLE="My Account";

	public static final String LOGIN_PAGE_FRACTION_URL="route=account/login";
	public static final String ACCOUNT_PAGE_FRACTION_URL="route=account/account";
	
	public static final List<String> ACC_PAGE_HEADERS_LIST= Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	
	public static final String LIST_NOT_MATCHED="------List Not Matched------";
}
