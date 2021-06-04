package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

public class LoginPage {
	
	private WebDriver driver ;
	
	// By Locator
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInBUtton = By.id("SubmitLogin");
	private By ForgotPasswordLink = By.linkText("Forgot your password?");
	
	// create constructor of page class
	
	public LoginPage(WebDriver driver) {

		this.driver=driver;
	}

	// Page Actions 
	public String getLoginTitle() {
		
		 return driver.getTitle();		
	}

	public boolean ForgotPasswordLink() {
		
		return driver.findElement(ForgotPasswordLink).isDisplayed();			
	}

		public void enterUsername(String username) {
			
			driver.findElement(emailId).sendKeys(username);
					
		}

		public void enterPassword(String pass) {
			
			driver.findElement(password).sendKeys(pass);
		}
			
		public void clickOnLogin () {
			
			driver.findElement(signInBUtton).click();
			
		}

}
