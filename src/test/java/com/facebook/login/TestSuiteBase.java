package com.facebook.login;

import appcode.HomePage;
import appcode.LoginPage;
import genericmethod.GenericMethodDemo;
import utilities.Constants;
import utilities.ExcelUtility;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestSuiteBase {
	protected WebDriver driver;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected GenericMethodDemo gm;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String version, String url) throws Exception {
		
		driver = getDriverInstance( browser, version, url);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		gm = new GenericMethodDemo(driver);
		
		// used to set the excel path
		ExcelUtility.setExcelFile(Constants.ExcelPath, Constants.ExcelSheetName);

	}

	public static WebDriver getDriverInstance( String browser, String version, String url)
			throws MalformedURLException {
		String Node = "http://localhost:4444";
		WebDriver driver = null;		

		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new RemoteWebDriver(new URL(Node), chromeOptions);

		}
		if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications");
			driver = new RemoteWebDriver(new URL(Node), edgeOptions);

		}

		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-notifications");
			firefoxOptions.addArguments("--session-override true");
			driver = new RemoteWebDriver(new URL(Node), firefoxOptions);
		}

		driver.get(url);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.get(Constants.Url);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}