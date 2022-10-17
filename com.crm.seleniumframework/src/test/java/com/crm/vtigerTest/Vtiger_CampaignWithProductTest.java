package com.crm.vtigerTest;

import org.testng.annotations.Test;

import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.CampaignsPage;
import com.crm.pomrepositary.HomePage;

public class Vtiger_CampaignWithProductTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})
public void campaignwithproductTest() throws Throwable {
	Java_Utility javalibrary=new Java_Utility();
	Exel_Utility exelLibrary=new Exel_Utility();
	
	//use exel utility
	int ranNum = javalibrary.getRandomNumber(1000);
	String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,0)+ranNum;
	
	//click on campaign module
	HomePage home=new HomePage(driver);
	home.ClickCampaignsModule();
	
	//create campaign with product after verify the page and delete the campaignaccount
	CampaignsPage campaign=new CampaignsPage(driver);
	campaign.campaignpage(cellsheet);
	campaign.CampaignWithProduct(driver, "Campaigns");
	campaign.clickonsavebutton();
	campaign.campaignVerification(cellsheet);
	campaign.deleteCampaign(driver);
	 
	//signout the page
	home.signout();
}
}
