package genericmethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericMethodDemo {
	private WebDriver driver;

	public GenericMethodDemo(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {

		type = type.toLowerCase();

		if (type.equals("id")) {

			System.out.println("Element found with id: " + locator);

			return driver.findElement(By.id(locator));
		}

		else if (type.equals("xpath")) {

			System.out.println("Element found with xpath: " + locator);

			return driver.findElement(By.xpath(locator));
		}

		else if (type.equals("name")) {

			System.out.println("Element found with name: " + locator);

			return driver.findElement(By.name(locator));
		}

		else if (type.equals("linktext")) {

			System.out.println("Element found with linktext: " + locator);

			return driver.findElement(By.linkText(locator));
		}

		else if (type.equals("partiallinktext")) {

			System.out.println("Element found with partiallinktext: " + locator);

			return driver.findElement(By.partialLinkText(locator));
		}

		else if (type.equals("cssselector")) {

			System.out.println("Element found with cssselector: " + locator);

			return driver.findElement(By.cssSelector(locator));
		}

		else if (type.equals("classname")) {

			System.out.println("Element found with classname: " + locator);

			return driver.findElement(By.className(locator));
		}

		else if (type.equals("tagname")) {

			System.out.println("Element found with tagname: " + locator);

			return driver.findElement(By.tagName(locator));
		}

		else {
			System.out.println("Not a valid Locator");
			return null;
		}

	}

	public List<WebElement> getElements(String locator, String type) {

		type = type.toLowerCase();

		if (type.equals("id")) {

			System.out.println("Element found with id: " + locator);

			return driver.findElements(By.id(locator));
		}

		else if (type.equals("xpath")) {

			System.out.println("Element found with xpath: " + locator);

			return driver.findElements(By.xpath(locator));
		}

		else if (type.equals("name")) {

			System.out.println("Element found with name: " + locator);

			return driver.findElements(By.name(locator));
		}

		else if (type.equals("linktext")) {

			System.out.println("Element found with linktext: " + locator);

			return driver.findElements(By.linkText(locator));
		}

		else if (type.equals("partiallinktext")) {

			System.out.println("Element found with partiallinktext: " + locator);

			return driver.findElements(By.partialLinkText(locator));
		}

		else if (type.equals("cssselector")) {

			System.out.println("Element found with cssselector: " + locator);

			return driver.findElements(By.cssSelector(locator));
		}

		else if (type.equals("classname")) {

			System.out.println("Element found with classname: " + locator);

			return driver.findElements(By.className(locator));
		}

		else if (type.equals("tagname")) {

			System.out.println("Element found with tagname: " + locator);

			return driver.findElements(By.tagName(locator));
		}

		else {
			System.out.println("Not a valid Locator");
			return null;
		}

	}

	public boolean isElementPresent(String locator, String type) {

		List<WebElement> lists = getElements(locator, type);

		if (lists.size() > 0) {

			return true;
		} else {
			return false;
		}

	}

	public WebElement waitforElement(By locator, Duration timeOut) {

		WebElement element = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		}

		catch (Exception e) {

			System.out.println("Element not available");

		}

		return element;

	}

	public WebElement waitforElementUsingWebElement(WebElement element, Duration timeOut) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			//element = wait.until(ExpectedConditions.visibilityOf(element));
			
			wait.until(ExpectedConditions.visibilityOf(element));

		}

		catch (Exception e) {

			System.out.println("Element not available");

		}

		return element;

	}

	public void clickWhenReady(By locator, Duration timeOut) {

		WebElement element = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();

		}

		catch (Exception e) {

			System.out.println("Element not avaialble to click");
		}

	}

	public void datePicker(WebElement month, List<WebElement> allDays, String date) throws InterruptedException {

		for (WebElement element : allDays) {

			System.out.println(element.getText());

			if (element.getText().contains(date)) {

				element.click();

				Thread.sleep(3000);

				break;
			}
		}

	}

}
