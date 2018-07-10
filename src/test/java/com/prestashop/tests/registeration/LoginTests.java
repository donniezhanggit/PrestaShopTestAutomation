package com.prestashop.tests.registeration;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.LoginPage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests extends TestBaseClass {

	
	
	//comment added to try git push
	
	
	@Test ( groups= {"smoke","regression"})
	public void positiveLoginTest() {
	
		HomePage homePage=new HomePage(driver);
		//verify at page 
		assertTrue(homePage.isAt());
		//verify logo is displayed
		assertTrue(homePage.logo.isDisplayed() );
		homePage.gotoLoginPage();
		LoginPage loginPage= new LoginPage(driver);
		assertTrue(loginPage.isAt()); 
		assertTrue(loginPage.createAccountLabel.isDisplayed());
		assertTrue(loginPage.alreadyRegisteredLabel.isDisplayed()); 
		
		//Email valid email and password then click sign in
		loginPage.login();
		
		MyAccountPage accountPage= new MyAccountPage(driver); 
		assertTrue(accountPage.isAt()); 
		assertTrue(accountPage.verifyUserOptions("Order history and details",
									 "My credit slips",
									 "My addresses",
									 "My personal information",
									 "My wishlists"));
		
	}


	
	
}
