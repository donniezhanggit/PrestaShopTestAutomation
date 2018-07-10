package com.prestashop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver; 
	String searchQuery="Printed Summer Dress"; 
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  // this will initiliaze all webelements
	}

	@FindBy(linkText="Sign in")						// this is a new way to find elements. Put all elements for each
	public WebElement signInLink; 
	
	@FindBy (xpath="//img[@class='logo img-responsive']")
	public WebElement logo;
	
	public WebElement search_query; // if it is id or classname we do not need FindBy selenium will find it
	
	@FindBy(xpath = "//span[@class='shop-phone']")
	public WebElement callUsNow;
	
	// @FindBy(className="content_price")
	@FindBy(xpath = "//ul[@id='homefeatured']/li//div[@class='right-block']//span[@class='price product-price']")
	public List<WebElement> allPrices;
	
	@FindBy(id = "//*[@id='contact-link']/a")
	public WebElement contactUs;
	
	public boolean isAt() {
		return driver.getTitle().equals("My Store"); 
	}
	
	public void gotoLoginPage() {
		signInLink.click();
		
	}
	
	public WebElement listing(String product) {
		return driver.findElement(By.cssSelector("a.product-name[title='"+product+"']"));
	}
	
	
}
