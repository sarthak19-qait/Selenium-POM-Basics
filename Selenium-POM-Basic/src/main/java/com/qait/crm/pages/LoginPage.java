package com.qait.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.crm.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginTitile() {
		return driver.getTitle();
	}
	
	public boolean crmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un , String pw) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
	}
	
}
