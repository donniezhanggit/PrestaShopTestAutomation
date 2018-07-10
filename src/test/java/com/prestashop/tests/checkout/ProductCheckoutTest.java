package com.prestashop.tests.checkout;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductCheckoutTest extends TestBaseClass {

	WebDriver driver; 
	String productName="Printed Summer Dress";
	
	
	
	@Test(priority=1  )
	public void productListing() {
		HomePage homePage=new HomePage(driver); 
		homePage.listing(productName).click();
		ProductPage productPage=new ProductPage(driver); 
		assertEquals(productPage.name.getText(), productName); 
		
		
	}
	
	@Test(priority=2, dependsOnMethods="productListing" , groups="smoke")
	public void checkOutTest() {
		
		ProductPage productPage=new ProductPage(driver); 
		productPage.addToCart.click();
		//explicit wait
		Wait<WebDriver> wait=new WebDriverWait(driver, 3); 
				wait.until(ExpectedConditions.visibilityOf(productPage.confirmation)); 
		
		assertTrue(productPage.confirmation.isDisplayed()); 
		String confirmation= "Product successfully added to your shopping cart"; 
		assertEquals(productPage.confirmation.getText().trim(), confirmation);
		
	}
	
	
	
}
