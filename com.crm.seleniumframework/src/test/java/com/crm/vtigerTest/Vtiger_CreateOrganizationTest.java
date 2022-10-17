package com.crm.vtigerTest;

import org.testng.annotations.Test;
import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.HomePage;
import com.crm.pomrepositary.OrganizationsPage;

public class Vtiger_CreateOrganizationTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})
	public void createOrganizationTest() throws Throwable {
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		
		HomePage home=new HomePage(driver);
		home.ClickOrganizationsModule();
		
		int ranNum = javalibrary.getRandomNumber(1000);
		System.out.println("ranNum="+ranNum);
		String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,1)+ranNum;
		
		OrganizationsPage organization=new OrganizationsPage(driver);
		organization.organizationpage(cellsheet);
		organization.clickonsavebutton();
		organization.organizationpageVerification(cellsheet);
	    organization.deleteOrganization(driver);
	    
	    home.signout();
	}
}
