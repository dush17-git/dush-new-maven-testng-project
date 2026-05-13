package com.pkg.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	private WebDriver driver;
	
	//Locators	
	private By usernameTextBox = By.id("user-name");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginError = By.cssSelector("[data-test='error']");
    
    
    public LoginPage(WebDriver driver){
    	this.driver =driver;
    }
    
    //Action
    public void enterUsername(String username) {
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
    public ProductsPage clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
 
    	driver.findElement(loginButton).click();
    	
    	return new ProductsPage(driver);	//Returning a ProductsPage Object, with the driver.
    }
    
    public String getErrorMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(loginError));
    	
    	return driver.findElement(loginError).getText();
    }
}
