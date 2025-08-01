package com.pkg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
    	
    	driver.findElement(loginButton).click();
    }
}
