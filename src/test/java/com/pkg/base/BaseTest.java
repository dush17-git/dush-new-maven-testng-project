package com.pkg.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver wdriver;
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		ChromeOptions options = new ChromeOptions(); 
		
		//Creating a temp-directory for Chrome profile.		
		Path tempPath = Files.createTempDirectory("chrome-temp-test-dir-");
		
		//Chrome to use the new temp-directory.
		options.addArguments("--user-data-dir="+ tempPath.toAbsolutePath().toString());
		
		//Comment these commandline arguments when run locally.
		options.addArguments("--headless=new"); //To enable a new headless mode. 
	    options.addArguments("--disable-gpu");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
		
				
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize();
		wdriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}
	
	@AfterMethod
	public void closeDriver() {
		if(wdriver != null) {
	    	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
			wdriver.quit();;
		}
	}

}
