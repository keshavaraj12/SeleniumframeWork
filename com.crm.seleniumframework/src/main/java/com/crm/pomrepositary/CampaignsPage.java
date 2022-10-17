package com.crm.pomrepositary;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic_utilitie.WebDriver_Utility;

public class CampaignsPage {

	//intialization
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath ="//td[@style='padding-right:0px;padding-left:10px;']//a//img[@title='Create Campaign...']")
	private WebElement ClickOnCreateCampaign;
	
	@FindBy(xpath ="//input[@name='campaignname']")
	private WebElement CampaignName;
	
	@FindBy(xpath ="//img[@alt='Select']")
	private WebElement ClickOnPluseImage;
	
	@FindBy(xpath ="//table[@class='small']//a[@id='1']")
	private WebElement ClickOnTableFist;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSavebutton;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement CampaignTextName;
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement CapaignEdit;
	
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement DeleteCampaign;
	
	//getter method
	public WebElement getClickOnCreateCampaign() {
		return ClickOnCreateCampaign;
	}
	
	public WebElement getCampaignName() {
		return CampaignName;
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
	
	public WebElement getCampaignTextName() {
		return CampaignTextName;
	}
	
	public WebElement getCapaignEdit() {
		return CapaignEdit;
	}
	
	public WebElement getDeleteCampaign() {
		return DeleteCampaign;
	}
	

	//Business logic method
	public void campaignpage(String name) {
		ClickOnCreateCampaign.click();
		CampaignName.sendKeys(name);
	}
	
	public void CampaignWithProduct(WebDriver driver,String partialtitle) {
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
			System.out.println("Product is created");
			driver.switchTo().window(parent);
	}
	
	public void clickonsavebutton() {
		ClickOnSavebutton.click();
	}
	
	public void campaignVerification(String cellsheet) {
		String CamName = CampaignTextName.getText();
		//System.out.println("CamName= "+CamName);
		if(CamName.contains(cellsheet))
		{
			System.out.println("Created campaign_info is sucussfully");
		}else {
			System.out.println("Created campaign_info is unsucussfully");
		}
	}
	
	public void capaignedit() {
		CapaignEdit.click();
	}
	
 WebDriver_Utility webLibrary=new WebDriver_Utility();
	public void deleteCampaign(WebDriver driver) {
		DeleteCampaign.click();
		webLibrary.useAlertAccept(driver);
	    System.out.println("delete sucussfully");
	}
}
