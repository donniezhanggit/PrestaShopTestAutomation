package com.prestashop.tests.search;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.pages.ResultsPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductDetailsTest extends TestBaseClass{

	

	String searchQuery="Printed Summer Dress";
	
	
	
	@Test(priority=1)
	public void searchTest() {
	
		HomePage homePage=new HomePage(driver); 
		homePage.search_query.sendKeys(searchQuery + Keys.ENTER);
		ResultsPage resultsPage= new ResultsPage(driver); 
		assertTrue (resultsPage.result(searchQuery).isDisplayed());
		
	}
	
	@Test(priority=2)
	public void productDetailsTest() {
		ResultsPage resultsPage= new ResultsPage(driver); 
		resultsPage.result(searchQuery).click();
		ProductPage productPage= new ProductPage(driver); 
		assertEquals(productPage.name.getText(), searchQuery); 
		
		
	}
	
//	@Test(priority=3)
//	public void anotherTest() {
//		ResultsPage resultsPage= new ResultsPage(driver); 
//		resultsPage.result(searchQuery).click();
//		ProductPage productPage= new ProductPage(driver); 
//		assertEquals(productPage.name.getText(), searchQuery); 
//		
//		
//	}
	
	
	
	
	
}
