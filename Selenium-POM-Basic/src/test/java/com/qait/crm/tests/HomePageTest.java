package com.qait.crm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.crm.base.TestBase;
import com.qait.crm.pages.ContactsPage;
import com.qait.crm.pages.DealsPage;
import com.qait.crm.pages.HomePage;
import com.qait.crm.pages.LoginPage;
import com.qait.crm.pages.TaskPage;
import com.qait.crm.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	DealsPage dealPage;
	TaskPage taskPage;
	
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialisation();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactPage = new ContactsPage();
		dealPage = new DealsPage();
		taskPage = new TaskPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		String title = homePage.homePageTitile();
		Assert.assertEquals(title, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabel() {
		testUtil.switchToFrame();
		boolean a = homePage.userNameLabel();
		Assert.assertTrue(a);
	}
	
	@Test(priority=3)
	public void verifyContactsLink() throws IOException {
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}
	
	@Test
	public void verifyDealsLink() throws IOException {
		testUtil.switchToFrame();
		dealPage = homePage.clickOnDealsLink();
	}
	
	@Test
	public void verifyTaskLink() throws IOException {
		testUtil.switchToFrame();
		taskPage = homePage.clickOnTasksLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
