package com.crm.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Declaration
	@FindBy(name="user_name")
	private WebElement usernameTextfild;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfild;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	//getter method
	public WebElement getUsernameTextfild() {
		return usernameTextfild;
	}

	public WebElement getPasswordTextfild() {
		return passwordTextfild;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business logic method
	public void loginpage(String userName,String passWord) {
		usernameTextfild.sendKeys(userName);
		passwordTextfild.sendKeys(passWord);
		submitButton.click();
	}
	
}
