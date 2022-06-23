package com.vangoghmuseum.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowsersHelper {
	private static BrowsersHelper launchbrowser;
	public static WebDriver driver;
	public static WebElement element;

	private BrowsersHelper(WebDriver driver) {
		this.driver = driver;
	}

	public static BrowsersHelper getInstance(WebDriver driver) {
		if (launchbrowser == null || launchbrowser.hashCode() != driver.hashCode()) {
			launchbrowser = new BrowsersHelper(driver);
			Log.info("Browser has been launched successfully.");
		}
		return launchbrowser;
	}

	public WebElement findWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("Xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
			Log.info("Locator :" + element.getTagName());
			System.out.println(element);
		} else if (locatorType.equalsIgnoreCase("Id")) {
			element = driver.findElement(By.id(locatorValue));
			Log.info("Locator :" + element);
		} else if (locatorType.equalsIgnoreCase("Css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
			Log.info("Locator :" + element);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locatorValue));
			Log.info("Locator :" + element);
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
			Log.info("Locator :" + element);
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));
			Log.info("Locator :" + element);
		} else {
			Log.info("Locator type which is Enter by you does not matched");
		}
		return element;
	}

	public void enterValueInTextbox(String testData, String locatorType, String locatorValue) throws InterruptedException {
		Thread.sleep(1000);
		element = findWebElement(locatorType, locatorValue);
		element.clear();
		element.sendKeys(testData);
		Log.info(testData+" Enter into textbox.");
	}

	public String getText(String locatorType, String locatorValue) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(findWebElement(locatorType, locatorValue)));
		// wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		String browserTest = element.getText().toString();
		Log.info("Found text from browser: " + browserTest);
		return browserTest;
	}
	
	public int getNumberCountfrombrowser(String locatorType, String locatorValue) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(findWebElement(locatorType, locatorValue)));
		// wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		String browserTest = element.getText().toString();
		int i=Integer.parseInt(browserTest);  
		Log.info("Found text from browser: " + browserTest);
		return i;

	}
	
	public boolean verifyTextBox(String locatorType, String locatorValue) {
		boolean b=false;
		if(element!=null) {
			b=true;
			Log.info("text box found in browser ?: " + b);
		}
		else {
			Log.info("text box found in browser ?: " + b);
		}
		
		return b;
		
	}

	public void callcustomWaitMethod() {
		// here we can call custom function as
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(customWait());
	}

	public Function<WebDriver, Boolean> customWait() {
		Function<WebDriver, Boolean> wait = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver t) {
				if (t.findElement(By.xpath("")).getText().toString().equalsIgnoreCase("")) {
					return true;
				}
				return false;
			}
		};
		return wait;
	}

	public void click(String locatorType, String locatorValue) throws InterruptedException {
		Thread.sleep(1000);
		findWebElement(locatorType, locatorValue).click();
		Log.info("Click on respective web element");
	}

	public void moveAndclick(String locatorType, String locatorValue) throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.pollingEvery(5, TimeUnit.SECONDS);
		// wait.ignoring(NoSuchElementException.class);
		// System.out.println("test :" + findWebElement(locatorType, locatorValue));
		// wait.until(ExpectedConditions.elementToBeClickable(findWebElement(locatorType,
		// locatorValue)));
		// wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		Actions actions = new Actions(driver);
		actions.moveToElement(findWebElement(locatorType, locatorValue)).click().build().perform();
		Thread.sleep(1000);
		Log.info("Click on respective web element");
		findWebElement(locatorType, locatorValue).click();
	}

	public void switchTonewTab() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		List<String> aList = new ArrayList<String>(allWindow);
		// driver.close();
		driver.switchTo().window(aList.get(1));
		// driver.close();
		Thread.sleep(1000);
		// driver.switchTo().window(aList.get(0));
		/*
		 * for(String window:aList) { if(!window.equals(parentWindow) &&window!=null) {
		 * driver.switchTo().window(window);
		 * System.out.println("Driver has been switch successfully."+window); }else {
		 * System.out.println("Unable to switch"); } }
		 */
	}

	public void setImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
		Log.info("Maximaized window");
	}

	public void moveforward() {
		driver.navigate().forward();
	}

	public void backword() {
		driver.navigate().back();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void gowithUrl(String url) {
		driver.navigate().to(url);
	}

	public void enterUrl(String url) {
		driver.get(url);
		Log.info("url has been opened");
	}

	public void accept_confirmationPopup() throws InterruptedException {
		Thread.sleep(1500);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Log.info("Java script popup hass been closed.");
	}

	public void dismiss_confirmationPopup() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getText_confirmationPopup() {
		Alert alert = driver.switchTo().alert();
		return alert.getText().toString();
	}

	public void takescreenshot(String imageName) throws InterruptedException {
		Thread.sleep(1500);
		// Take the screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copy the file to a location and use try catch block to handle exception
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_");
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/"
					+ imageName + FileName + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Log.info("Screenshot clicked.");
	}
	public void quitebrowser() {
		driver.quit();
		Log.info("Browser Closed.");
	}
}
