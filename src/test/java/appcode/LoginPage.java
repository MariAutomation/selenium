package appcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericmethod.GenericMethodDemo;

public class LoginPage {
	WebDriver driver;
	GenericMethodDemo gm;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		gm = new GenericMethodDemo(driver);
	}

	@FindBy(id = "email")
	WebElement emailAddress;

	@FindBy(id = "email")
	List<WebElement> emailField;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(name = "login")
	WebElement login;

	@FindBy(xpath = "//a[contains(text(),'Forgotten')]")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//div[@class='_6ltg']//a")
	WebElement createNewAccount;

	@FindBy(xpath = "//div[@class='clearfix _5466 _44mg']//div[2]")
	WebElement errorMessage;

	public void enterEmailAddress(String text) {

		emailAddress.sendKeys(text);
	}

	public void enterPAssword(String text) {
		password.sendKeys(text);

	}

	public void clickOnlogin() {
		login.click();

	}

	public WebElement waitForErrorMessage() {
		return gm.waitforElementUsingWebElement(errorMessage, Duration.ofSeconds(4));
	}

	public WebElement waitforEmailField() {
		return gm.waitforElementUsingWebElement(emailAddress, Duration.ofSeconds(4));
	}

	public boolean isEmailFieldPresent() {
		return emailField.size() > 0;
	}

}
