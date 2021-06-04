package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/*  This method is used to initlize threadlocal driver on the basis of giver browser
	 * @param browser
	 * @return this will return tlDriver 
	 * */
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("browser value is " + browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			tlDriver.set(new ChromeDriver());
			
  			
		}
	
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			tlDriver.set(new FirefoxDriver());
			
		}
	else if(browser.equals("safari")) {
	
			tlDriver.set(new SafariDriver());
			}		
	else {
		
		System.out.println("Please Pass the correct value" + browser);
	}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		
		return getDriver();
		
	}
	
	/*  This method is used to get driver with thread local  */
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
				
	}

	
	
}
