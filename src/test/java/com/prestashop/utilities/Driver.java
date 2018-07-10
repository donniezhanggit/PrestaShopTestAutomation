package com.prestashop.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * WebDriver factory
 * takes string as input and returns the implementation of the webdriver based on that
 */
public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		// read the browser type 
		String driverType = browser==null? Configuration.getProperty("browser") : browser;
		
		// if browser has value, use browser
		// else use the value from the configuration file
		
		if (driver == null) {
			// create webdriver based on the value of browser parameter
			switch (driverType.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				
				break;
			case "safari":
				
				driver = new SafariDriver();
				break;
			case "edge":
				
				break;
			}
		}
		// return
		return driver;
	}
	
	public static void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}