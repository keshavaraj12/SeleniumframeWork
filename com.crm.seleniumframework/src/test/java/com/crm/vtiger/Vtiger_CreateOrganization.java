package com.crm.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.File_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.generic_utilitie.WebDriver_Utility;
import com.crm.pomrepositary.HomePage;
import com.crm.pomrepositary.LoginPage;
import com.crm.pomrepositary.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_CreateOrganization {
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		File_Utility fileLibrary=new File_Utility();
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		WebDriver_Utility webLibrary=new WebDriver_Utility();
		
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
		}
		webLibrary.useMaximize(driver);
		webLibrary.useImplicitWait(driver);
		
		String URL = fileLibrary.PropertyFile("url");
		String username = fileLibrary.PropertyFile("un");
		String password = fileLibrary.PropertyFile("pwd");
		System.out.println("username="+username);
		System.out.println("password="+password);
		driver.get(URL);
		
		LoginPage login=new LoginPage(driver);
		login.loginpage(username, password);
		
		int ranNum = javalibrary.getRandomNumber(1000);
		System.out.println("ranNum="+ranNum);
		
		String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,1)+ranNum;
		
		HomePage home=new HomePage(driver);
		home.ClickOrganizationsModule();
		
		OrganizationsPage organization=new OrganizationsPage(driver);
		organization.organizationpage(cellsheet);
		organization.clickonsavebutton();
		organization.organizationpageVerification(cellsheet);
	    organization.deleteOrganization(driver);
	    
	    home.signout();
	    
	    webLibrary.useMinimize(driver);
		driver.quit();
	}

}
