package com.crm.vtigerTest;

import org.testng.annotations.Test;

import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.ContactsPage;
import com.crm.pomrepositary.HomePage;

public class Vtiger_ContactWithOrganizationTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})
	public void contactwithorganizationTest() throws Throwable {
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		
		//Imapliment the java and exel utility
		int ranNum = javalibrary.getRandomNumber(1000);
		String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,0)+ranNum;
		
		//Click on contact module in home page
		HomePage home=new HomePage(driver);
		home.ClickContactsModule();
		
		//create the contact with organization  after verify the page and delete the contactaccount 
		ContactsPage contact=new ContactsPage(driver);
		contact.contactpage(cellsheet,"raj");
		contact.ContactWithOrganization(driver,"Contacts");
		contact.clickonsavebutton();
		contact.contactVerification(cellsheet);
		contact.deleteContact(driver);
		
	    //signout the page
		home.signout();	
}
}
