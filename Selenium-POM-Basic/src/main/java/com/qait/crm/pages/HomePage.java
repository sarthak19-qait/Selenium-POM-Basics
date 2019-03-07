package com.qait.crm.pages;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qait.crm.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[conatins(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),Contacts)]")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),Deals)]")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),Tasks)]")
	@CacheLookup
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),New Contact)]")
	@CacheLookup
	WebElement newContact;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitile() {
		return driver.getTitle();
	}
	
	public boolean userNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickOnTasksLink() throws IOException {
		tasksLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactLink() throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
		
	}
	
	


}
