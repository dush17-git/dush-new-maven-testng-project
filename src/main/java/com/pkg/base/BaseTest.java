package com.pkg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new"); //Remove when debugging in local.
	    options.addArguments("--no-sandbox"); //Remove when debugging in local.
        options.addArguments("--disable-dev-shm-usage"); //Remove when debugging in local.
        
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
	}
	
	@AfterMethod
	public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
	}

}
