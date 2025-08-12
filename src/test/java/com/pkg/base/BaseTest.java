package com.pkg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver wdriver;
	
	@BeforeMethod
	public void setUp(){
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize();
		wdriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}
	
	@AfterMethod
	public void closeDriver() {
		if(wdriver != null) {
	    	
			try {
				Thread.sleep(3000);             //Thread is a Java class, used here to invoke sleep().
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			wdriver.quit();;
		}
	}

}
