package com.prestashop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestashop.utilities.Configuration;



public class LoginPage {
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy (id="email")
	public WebElement loginEmail; 
	
	@FindBy(id="passwd")
	public WebElement password; 
	
	@FindBy (id="SubmitLogin")
	public WebElement signInButton; 
	
	@FindBy(id="email_create")
	public WebElement createEmail; 
	
	@FindBy(id="SubmitCreate")
	public WebElement createButton; 
	
	@FindBy(xpath="//h3[.='Already registered?']")
	public WebElement alreadyRegisteredLabel; 
	
	@FindBy (xpath="//h3[.='Create an account']")
	public WebElement createAccountLabel;
	
	
	public boolean isAt() {
		return driver.getTitle().equals("Login - My Store"); 
	}
	
	
	public void login() {
		loginEmail.sendKeys(Configuration.getProperty("id"));	
		password.sendKeys(Configuration.getProperty("password"));
		signInButton.click();
	}
	
	public void createAccountLink() {
		createEmail.sendKeys(Configuration.getProperty("new email"));
		createButton.click();
	}
	
	
}
