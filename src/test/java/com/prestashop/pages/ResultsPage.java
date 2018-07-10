package com.prestashop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

	
	private WebDriver driver;

	
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	
	public WebElement result(String product) {                        // dynamic way to write an element
		return driver.findElement(By.xpath("//ul[@class='product_list grid row']//a[@title='"+product+"']"));
		
	}
	
}
