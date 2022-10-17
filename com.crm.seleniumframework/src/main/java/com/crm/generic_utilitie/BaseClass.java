package com.crm.generic_utilitie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.pomrepositary.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	File_Utility fileLibrary=new File_Utility();
	Java_Utility javalibrary=new Java_Utility();
	Exel_Utility exelLibrary=new Exel_Utility();
	WebDriver_Utility webLibrary=new WebDriver_Utility();
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS() {
		System.out.println("Database connection");
	}
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT() {
		System.out.println("Execute in parallel mode");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//public void BC(String BROWSER) throws Throwable {
	public void BC() throws Throwable {
		System.out.println("Launching the Browser");
		String Browser = fileLibrary.PropertyFile("browser");
		/*if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}*/
		
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
		sdriver=driver;
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable {
		System.out.println("Login to Application");
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
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM() {
		System.out.println("Logout the Application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC() {
		System.out.println("Close the Browser");
		webLibrary.useQuit(driver);
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT() {
		System.out.println("Executed sucessfully ");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS() {
		System.out.println("Database close");
	}
}
