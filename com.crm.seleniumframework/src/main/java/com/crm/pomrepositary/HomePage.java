package com.crm.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
		//intialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		//Declaration
		@FindBy(xpath ="//td[@class='tabUnSelected']//a[text()='Organizations']")
		private WebElement ClickOnOrganizations;
		
		@FindBy(xpath ="//td[@class='tabUnSelected']//a[text()='Contacts']")
		private WebElement ClickOnContacts;
		
		@FindBy(xpath ="//td[@class='tabUnSelected']//a[.='Products']")
		private WebElement ClickOnProducts;
		
		
		@FindBy(xpath="//a[.='More']")
		private WebElement ClickOnMore;
		
		@FindBy(xpath="//a[.='Campaigns']")
		private WebElement ClickOnCampaigns;
		
		@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
		private WebElement ClickOnSignoutImage;
		
		@FindBy(xpath ="//a[.='Sign Out']")
		private WebElement ClickOnSignout;
		
		
		//getter method
		public WebElement getClickOnOrganizations() {
			return ClickOnOrganizations;
		}
		
		public WebElement getClickOnContacts() {
			return ClickOnContacts;
		}

		public WebElement getClickOnProducts() {
			return ClickOnProducts;
		}

		public WebElement getClickOnMore() {
			return ClickOnMore;
		}

		public WebElement getClickOnCampaigns() {
			return ClickOnCampaigns;
		}

		public WebElement getClickOnSignoutImage() {
			return ClickOnSignoutImage;
		}

		public WebElement getClickOnSignout() {
			return ClickOnSignout;
		}

		//Business logic method
		public void ClickOrganizationsModule() {
			ClickOnOrganizations.click();
		}
		
		public void ClickContactsModule() {
			ClickOnContacts.click();
		}

		public void ClickProductsModule() {
			ClickOnProducts.click();
		}

		public void ClickCampaignsModule() {
			ClickOnMore.click();
			ClickOnCampaigns.click();
		}
		public void signout() {
			ClickOnSignoutImage.click();
			ClickOnSignout.click();
		}
		
}
