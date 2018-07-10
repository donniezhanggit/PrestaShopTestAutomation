package com.prestashop.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//h1[.='My account']")
	public WebElement myAccountLabel; 
	
	@FindBy (xpath="//div[@class='row addresses-lists']//li")
	public List<WebElement> accountOptions; 
	
	public boolean verifyUserOptions(String ... options) {
		if(accountOptions.isEmpty())return false; 
		List<String> expected=new ArrayList<>(); 
		for (String each : options) {
			expected.add(each.toUpperCase()); 
		}
		List<String> actual= new ArrayList<>(); 
		for (WebElement opt : accountOptions) {
			actual.add(opt.getText()); 
		}
		return actual.containsAll(expected); 
	}
	
	public boolean isAt() {
		return driver.getTitle().equals("My account - My Store"); 
		
	}
	
}
