package com.crm.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic_utilitie.WebDriver_Utility;

public class OrganizationsPage {

			//intialization
			public OrganizationsPage(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}
			
			//Declaration
			@FindBy(xpath ="//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Organization...']")
			private WebElement ClickOnCreateOrganization;
			
			@FindBy(xpath ="//input[@name='accountname']")
			private WebElement OrganizationName;
			
			@FindBy(xpath ="//input[@title='Save [Alt+S]']")
			private WebElement ClickOnSavebutton;
			
			@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement OraganizationTextName;
			
			@FindBy(xpath="//input[@title='Delete [Alt+D]']")
			private WebElement DeleteOraganization;
			
			//getter method
			public WebElement getClickOnCreateOrganization() {
				return ClickOnCreateOrganization;
			}
			
			public WebElement getOrganizationName() {
				return OrganizationName;
			}

			public WebElement getClickOnSavebutton() {
				return ClickOnSavebutton;
			}
			
			public WebElement getOraganizationTextName() {
				return OraganizationTextName;
			}
			
			public WebElement getDeleteOraganization() {
				return DeleteOraganization;
			}
			

			//Business logic method
			public void organizationpage(String name) {
				ClickOnCreateOrganization.click();
				OrganizationName.sendKeys(name);
			}
			
			public void clickonsavebutton() {
				ClickOnSavebutton.click();
			}
			
			public void organizationpageVerification(String cellsheet) {
				String OrgName = OraganizationTextName.getText();
				System.out.println("OrgName= "+OrgName);
				if(OrgName.contains(cellsheet))
				{
					System.out.println("Created org_info is sucussfully");
				}else {
					System.out.println("Created org_info is unsucussfully");
				}
			}
			
		 WebDriver_Utility webLibrary=new WebDriver_Utility();
			public void deleteOrganization(WebDriver driver) {
				DeleteOraganization.click();
				webLibrary.useAlertAccept(driver);
			    System.out.println("delete sucussfully");
			}
			
			
}
