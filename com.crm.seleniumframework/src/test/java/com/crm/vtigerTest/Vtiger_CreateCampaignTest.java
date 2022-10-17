package com.crm.vtigerTest;

import org.testng.annotations.Test;
import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.CampaignsPage;
import com.crm.pomrepositary.HomePage;

public class Vtiger_CreateCampaignTest extends BaseClass {
	@Test(groups= {"smokeTest","regressionTest"})
	public void createCampaignTest() throws Throwable {
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		
		int ranNum = javalibrary.getRandomNumber(1000);
		System.out.println("ranNum="+ranNum);
		
		String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,0)+ranNum;
		
		/*
		 * Click on Campaigns module
		 */
		HomePage home=new HomePage(driver);
		home.ClickCampaignsModule();
		
		/*
		 * Enter the details and save the page
		 * Verify the page
		 */
		CampaignsPage campaign=new CampaignsPage(driver);
		campaign.campaignpage(cellsheet);
		campaign.clickonsavebutton();
		campaign.campaignVerification(cellsheet);
		
		/*
		 * Delete the campaign account
		 */
		campaign.deleteCampaign(driver);
		  
		/*
		 * signout the page
		 */
		home.signout();
	}
}
