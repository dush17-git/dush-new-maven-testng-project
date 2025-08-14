package com.pkg.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver wdriver;
	private String tempDir;
	
	@BeforeMethod
	public void setUp() throws IOException{
		//ChromeOptions options = new ChromeOptions();
	   // tempDir = Files.createTempDirectory("chrome-user-data").toString();
	   // options.addArguments("--user-data-dir=" + tempDir);
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
		
		// Delete tempDir if you stored its path
	    if (tempDir != null) {
	        try {
	            Files.deleteIfExists(Paths.get(tempDir));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
