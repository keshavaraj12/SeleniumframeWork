package com.crm.vtigerTest;

import org.testng.annotations.Test;
import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.ContactsPage;
import com.crm.pomrepositary.HomePage;

public class Vtiger_CreateContactTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})
	public void createContactTest() throws Throwable {
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		
		HomePage home=new HomePage(driver);
		home.ClickContactsModule();
		
		int ranNum = javalibrary.getRandomNumber(1000);
		System.out.println("ranNum="+ranNum);
		
		String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,0)+ranNum;
		
		ContactsPage contact = new ContactsPage(driver);
		contact.contactpage(cellsheet,"raj");
		contact.clickonsavebutton();
		contact.contactVerification(cellsheet);
		contact.deleteContact(driver);
		    
		home.signout();
	}
}
