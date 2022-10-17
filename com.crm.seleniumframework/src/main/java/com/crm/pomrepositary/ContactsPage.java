package com.crm.pomrepositary;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic_utilitie.WebDriver_Utility;


public class ContactsPage {
	public WebDriver driver;
	//intialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath ="//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Contact...']")
	private WebElement ClickOnCreateContact;
	
	@FindBy(xpath ="//input[@name='firstname']")
	private WebElement ContactFirstName;
	
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement ContactLastName;
	
	@FindBy(xpath ="//img[@alt='Select']")
	private WebElement ClickOnPluseImage;
	
	@FindBy(xpath ="//table[@class='small']//a[@id='1']")
	private WebElement ClickOnTableFist;

	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSavebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactTextName;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement DeleteContact;
	
	//getter method
	public WebElement getClickOnCreateContact() {
		return ClickOnCreateContact;
	}
	
	public WebElement getContactFirstName() {
		return ContactFirstName;
	}
	
	public WebElement getContactLastName() {
		return ContactLastName;
	}

	public WebElement getClickOnPluseImage() {
		return ClickOnPluseImage;
	}
	
	public WebElement getClickOnTableFist() {
		return ClickOnTableFist;
	}
	
	public WebElement getClickOnSavebutton() {
		return ClickOnSavebutton;
	}
	
	public WebElement getContactTextName() {
		return ContactTextName;
	}
	
	public WebElement getDeleteContact() {
		return DeleteContact;
	}
	

	//Business logic method
	public void contactpage(String Name,String name ) {
		ClickOnCreateContact.click();
		ContactFirstName.sendKeys(Name);
		ContactLastName.sendKeys(name);
	}
	
	public void ContactWithOrganization(WebDriver driver,String partialtitle) {
		ClickOnPluseImage.click();
		String parent = driver.getWindowHandle();
		Set<String> id = driver.getWindowHandles();
		for (String wid : id) {
			String eachtitle = driver.switchTo().window(wid).getTitle();
			if (eachtitle.contains(partialtitle))
			{
			 continue;    
			}}
			ClickOnTableFist.click();
			System.out.println("Organization is created");
			driver.switchTo().window(parent);
	}
	
	public void clickonsavebutton() {
		ClickOnSavebutton.click();
	}
	
	public void contactVerification(String cellsheet) {
		String ConName = ContactTextName.getText();
		//System.out.println("ConName= "+ConName);
		if(ConName.contains(cellsheet))
		{
			System.out.println("Created contact_info is sucussfully");
		}else {
			System.out.println("Created contact_info is unsucussfully");
		}
	}
	
 WebDriver_Utility webLibrary=new WebDriver_Utility();
	public void deleteContact(WebDriver driver) {
		DeleteContact.click();
		webLibrary.useAlertAccept(driver);
	    System.out.println("delete sucussfully");
	}
}
