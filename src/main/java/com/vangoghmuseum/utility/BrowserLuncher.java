package com.vangoghmuseum.utility;

import java.util.logging.Formatter;
import java.util.logging.Handler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserLuncher {
	static Handler filehandler;
	static Formatter formatter = null;
	public static WebDriver driver;
    public static BrowsersHelper browserhelper;
	public static void getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("CHROME")) {
			DriverSetup.setDriver(browserName);
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless", "--window-size=1920,1200");
			//WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);
			browserhelper=BrowsersHelper.getInstance(driver);
			browserhelper.setImplicitlyWait();
			browserhelper.maximizeWindow();
			Log.info("Google Chrome browser has been launched.");
		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			DriverSetup.setDriver(browserName);
			driver = new FirefoxDriver();
			browserhelper=BrowsersHelper.getInstance(driver);
			browserhelper.setImplicitlyWait();
			browserhelper.maximizeWindow();
			Log.info("Firefox Chrome browser has been launched.");
		} else if (browserName.equalsIgnoreCase("EDGE")) {
			DriverSetup.setDriver(browserName);
			driver = new EdgeDriver();
			browserhelper=BrowsersHelper.getInstance(driver);
			browserhelper.setImplicitlyWait();
			browserhelper.maximizeWindow();
		} else {
			System.out.println("Browser does not found in system.");
		}
	}
	public static void launchBrowser() {
		getDriver("CHROME");
	}
}
