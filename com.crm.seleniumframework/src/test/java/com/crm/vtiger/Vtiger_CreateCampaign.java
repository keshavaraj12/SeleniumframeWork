package com.crm.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.File_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.generic_utilitie.WebDriver_Utility;
import com.crm.pomrepositary.CampaignsPage;
import com.crm.pomrepositary.HomePage;
import com.crm.pomrepositary.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_CreateCampaign {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		File_Utility fileLibrary=new File_Utility();
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		WebDriver_Utility webLibrary=new WebDriver_Utility();
		
		//Launching the browser
		String Browser = fileLibrary.PropertyFile("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		/*
		 *pre-condition
		 * Maximize the browser and use the implicitwait
		 */
		webLibrary.useMaximize(driver);
		webLibrary.useImplicitWait(driver);
		
		/*
		 * fetch the data from property file
		 */
		String URL = fileLibrary.PropertyFile("url");
		String username = fileLibrary.PropertyFile("un");
		String password = fileLibrary.PropertyFile("pwd");
		System.out.println("username="+username);
		System.out.println("password="+password);
		
		/*
		 * Lunching the url
		 */
		driver.get(URL);
		
		/*
		 * Enter the valid credentials username and password
		 */
		LoginPage login=new LoginPage(driver);
		login.loginpage(username, password);
		
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
		  
		/*
		 * Post condition 
		 * quite the browser
		 */
		driver.quit();
		
	}
}
