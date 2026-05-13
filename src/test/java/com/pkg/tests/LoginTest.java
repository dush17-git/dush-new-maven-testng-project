package com.pkg.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pkg.base.BaseTest;
import com.pkg.pages.LoginPage;
import com.pkg.pages.ProductsPage;

public class LoginTest extends BaseTest{

	@Test
	public void validLogin() {
		LoginPage loginpage = new LoginPage(driver); //driver is WebDriver object from BaseTest.
		
		//Calling the LoginPage methods with values.
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickLoginButton();
		
		System.out.println("title of the page is: "+driver.getTitle());
		
        //Assert is a class in TestNG.
		Assert.assertEquals(driver.getTitle(),"Swag Labs"); 
		
		
	}
	
	@Test
	public void invalidLoginUserNm() {
		
		LoginPage loginpage = new LoginPage(driver); //driver is WebDriver object from BaseTest.
		
		//Calling the LoginPage methods with values.
		loginpage.enterUsername("standard_usrr");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickLoginButton();
		
		
		String loginerror = loginpage.getErrorMessage();
		
		System.out.println("Error message for invalid user name is: "+loginerror);
		Assert.assertEquals(loginerror, "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	@Test
	public void invalidLoginPwd() {
		
		LoginPage loginpage = new LoginPage(driver); //driver is WebDriver object from BaseTest.
		
		//Calling the LoginPage methods with values.
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("secret_sooce");
		loginpage.clickLoginButton();
		
		
		String loginerror = loginpage.getErrorMessage();
		
		System.out.println("Error message for invalid pwd is: "+loginerror);
		Assert.assertEquals(loginerror, "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	@Test
	public void invalidLoginBothUsnPwd() {
		
		LoginPage loginpage = new LoginPage(driver); //driver is WebDriver object from BaseTest.
		
		//Calling the LoginPage methods with values.
		loginpage.enterUsername("standard_usrr");
		loginpage.enterPassword("secret_sooce");
		loginpage.clickLoginButton();
		
		
		String loginerror = loginpage.getErrorMessage();
		
		System.out.println("Error message for invalid pwd is: "+loginerror);
		Assert.assertEquals(loginerror, "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	@Test
	public void emptyFieldLogin() {
		
		LoginPage loginpage = new LoginPage(driver); //WebDriver object from BaseTest passing to Page class by calling it's constructor.
		
		//Calling the LoginPage methods with values.
		loginpage.enterUsername("");
		loginpage.enterPassword("");
		loginpage.clickLoginButton();
		
		
		String loginerror = loginpage.getErrorMessage();
		
		System.out.println("Error message for empty fields is: "+loginerror);
		Assert.assertEquals(loginerror, "Epic sadface: Username is required");
		
	}

}
