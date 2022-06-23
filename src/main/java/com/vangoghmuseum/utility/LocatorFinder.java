package com.vangoghmuseum.utility;

import static com.vangoghmuseum.utility.BrowsersHelper.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LocatorFinder {
	public static WebElement element;

	public WebElement findWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("Xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
			Log.info("Locator :" + element);
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
}
