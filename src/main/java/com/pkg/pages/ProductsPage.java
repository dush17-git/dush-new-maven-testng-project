package com.pkg.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage {
	
	private WebDriver driver;
	
	private By titlename = By.cssSelector("[data-test='title']");
	
	public ProductsPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	//Action method
    public String getTitle() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(titlename));
    	
    	return driver.findElement(titlename).getText();
    	
    }
    
    

}
