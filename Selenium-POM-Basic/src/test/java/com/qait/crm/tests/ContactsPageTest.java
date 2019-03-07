package com.qait.crm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qait.crm.base.TestBase;
import com.qait.crm.pages.ContactsPage;
import com.qait.crm.pages.HomePage;
import com.qait.crm.pages.LoginPage;
import com.qait.crm.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	public ContactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialisation();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
		homePage.clickOnNewContactLink();
	}
	
	@Test(priority = 1)
	public void contactsLabelTest() {
		boolean a = contactPage.verifyContactsLabel();
		Assert.assertTrue(a,"Conatct label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectContactTest() {
		contactPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority = 3)
	public void multipleContactTest() {
		contactPage.selectContactsByName("test2 test2");
		contactPage.selectContactsByName("ui uii");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = testUtil.getTestData("Sheet1");
		return data;
	}
	
	@Test(priority = 4,dataProvider="getTestData")
	public void validateCreateNewContact(String title_page , String fname_page , String lname_page ,  String company_page) {
		contactPage.createNewContact(title_page,fname_page,lname_page,company_page);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	

}
