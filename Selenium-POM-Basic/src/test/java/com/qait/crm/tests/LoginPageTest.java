package com.qait.crm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.crm.base.TestBase;
import com.qait.crm.pages.HomePage;
import com.qait.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialisation();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginTitile();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	@Test(priority = 2)
	public void crmLogoTest() {
		boolean flag = loginPage.crmLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void loginTest() throws IOException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
