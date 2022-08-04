package com.facebook.login;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class TestData {
	
	@DataProvider(name = "invalidLogin")
	public Object[][] dataProvider_InvalidTest() {

		Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
		return testData;
	}
	
	@DataProvider(name = "validLogin")
	public Object[][] dataProvider_ValidTest() {

		Object[][] testData = ExcelUtility.getTestData("valid_login");
		return testData;
	}

}
