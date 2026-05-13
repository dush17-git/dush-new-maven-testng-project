package com.pkg.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pkg.base.BaseTest;
import com.pkg.pages.LoginPage;
import com.pkg.pages.ProductsPage;

public class ProductsTest extends BaseTest {
	
	@Test
	public void validTitle() {
		
	    // Need to login first to GET to products page
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUsername("standard_user");
	    loginpage.enterPassword("secret_sauce");
	    ProductsPage productspage = loginpage.clickLoginButton();
	    
	    // Assert products page
	    Assert.assertEquals(productspage.getTitle(), "Products", "Products page title missmatch");
	}

}
