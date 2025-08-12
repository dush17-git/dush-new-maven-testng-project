package com.pkg.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pkg.base.BaseTest;
import com.pkg.pages.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void validLogin() {
		LoginPage loginpage = new LoginPage(wdriver); //wdriver is WebDriver object from BaseTest.
		
		//Calling the LoginPage methods with values.
		loginpage.enterUsername("admin@yourstore.com");
		loginpage.enterPassword("admin");
		loginpage.pushLoginButton();
		
		System.out.println("title of the page is: "+wdriver.getTitle());
		
        //Assert is a class in TestNG.
		Assert.assertEquals(wdriver.getTitle(),"Dashboard / nopCommerce administration"); 
		
		
	}

}
