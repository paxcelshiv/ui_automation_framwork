package com.vangoghmuseum.utility;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverSetup {
	public static void setDriver(String browser) {
		//DOMConfigurator.configure("log4j.xml");
		if (browser.equalsIgnoreCase("CHROME")) {
			// WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			Log.info(browser + " has been launched.");
		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			Log.info(browser + " has been launched.");
		} else if (browser.equalsIgnoreCase("EDGE")) {
			WebDriverManager.edgedriver().setup();
			Log.info(browser + " has been launched.");
		} else {
			Log.info("Browser driver does not matched");
			System.out.println("Browser driver does not matched");
		}
	}
}
