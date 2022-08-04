package appcode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericmethod.GenericMethodDemo;

public class HomePage {

	WebDriver driver;
	GenericMethodDemo gm;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		gm = new GenericMethodDemo(driver);
	}

	@FindBy(xpath = "//i[@class='hu5pjgll op6gxeva']")
	List<WebElement> homeIcons;

	@FindBy(xpath = "//i[@class='hu5pjgll op6gxeva']")
	WebElement homeIcon;

	@FindBy(css = "div[role='button']  svg[role='img']  image")
	WebElement profileIcon;

	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement logOutButton;

	public void waitForHomePage() {
		gm.waitforElementUsingWebElement(homeIcon, Duration.ofSeconds(4));
	}

	public boolean isHomeIconPresent() {
		return homeIcons.size() > 0;
	}

	public void clickOnProfileIcon() {
		gm.waitforElementUsingWebElement(profileIcon, Duration.ofSeconds(4));
		profileIcon.click();
	}

	public void logOut() {
		gm.waitforElementUsingWebElement(logOutButton, Duration.ofSeconds(4));
		logOutButton.click();
	}

}