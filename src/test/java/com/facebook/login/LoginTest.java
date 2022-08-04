package com.facebook.login;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import dev.failsafe.internal.util.Assert;

public class LoginTest extends TestSuiteBase {
	
	@Test(dataProvider = "invalidLogin",dataProviderClass = TestData.class)
	public void inValidLogin(String username, String password) throws InterruptedException {

		String expectedError = "The password that you've entered is incorrect. Forgotten password?";
		loginPage.enterEmailAddress(username);
		loginPage.enterPAssword(password);
		loginPage.clickOnlogin();
		WebElement element = loginPage.waitForErrorMessage();
		String actualError = element.getText();
		Thread.sleep(2000);
		assertEquals(expectedError, actualError);
	}
	
	@Test(dataProvider = "validLogin",dataProviderClass = TestData.class)
	public void validLoginAndLogOut(String username, String password) throws InterruptedException {
		loginPage.enterEmailAddress(username);
		loginPage.enterPAssword(password);
		loginPage.clickOnlogin();
		homePage.waitForHomePage();
		Thread.sleep(2000);
		boolean result = homePage.isHomeIconPresent();
		Assert.isTrue(result, "testcase passed");
		homePage.clickOnProfileIcon();
		homePage.logOut();
		loginPage.waitforEmailField();
		boolean result1 = loginPage.isEmailFieldPresent();
		Thread.sleep(2000);
		Assert.isTrue(result1, "Test case is passed");
	}
	

}
