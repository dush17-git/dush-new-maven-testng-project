package com.pkg.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	private WebDriver driver;
	
	//Locators	
	private By usernameTextBox = By.xpath("//*[@id=\"Email\"]");
    private By passwordTextBox = By.id("Password");
    private By loginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
    
    public LoginPage(WebDriver driver){
    	this.driver =driver;
    }
    
    //Action
    public void enterUsername(String username) {
    	System.out.println("Page title: " + driver.getTitle());
    	System.out.println("Page source: " + driver.getPageSource());
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBox));
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
    }
    
    //Action
    public void enterPassword(String password) {
    	driver.findElement(passwordTextBox).clear();
    	driver.findElement(passwordTextBox).sendKeys(password);
    }
    
    //Action
    public void pushLoginButton() {
    	
    	try {
			Thread.sleep(3000);              //Thread is a Java class, used here to invoke sleep().
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
    	
    	driver.findElement(loginButton).click();
    }
}
