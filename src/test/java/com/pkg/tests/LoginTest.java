package com.pkg.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pkg.base.BaseTest;
import com.pkg.pages.LoginPage;

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

}
