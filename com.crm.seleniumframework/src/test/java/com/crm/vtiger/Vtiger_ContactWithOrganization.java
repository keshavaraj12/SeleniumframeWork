package com.crm.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.File_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.generic_utilitie.WebDriver_Utility;
import com.crm.pomrepositary.ContactsPage;
import com.crm.pomrepositary.HomePage;
import com.crm.pomrepositary.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_ContactWithOrganization {
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
		
		//minimize the browser and use the implicitwait as pre-condition
		webLibrary.useMaximize(driver);
		webLibrary.useImplicitWait(driver);
		
		// Impliment the file utility
		String URL = fileLibrary.PropertyFile("url");
		String username = fileLibrary.PropertyFile("un");
		String password = fileLibrary.PropertyFile("pwd");
		System.out.println("username="+username);
		System.out.println("password="+password);
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.loginpage(username, password);
		
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
		
	    //quit the browser	
		driver.quit();
	
}
}
