package com.crm.generic_utilitie;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForExtent {
	public WebDriver driver;
	public static WebDriver sDriver;
	public static ExtentReports report;
	public static ExtentTest test;
	WebDriver_Utility webLibrary=new WebDriver_Utility();
	@BeforeSuite
	public void configBS() {
		//DB connection
		System.out.println("Datebase connection");
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	    ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File(".\\ExtentReport\\report ["+timeStamp+"] .html"));		
        htmlReport.config().setDocumentTitle("Extent Report");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setReportName("Functional Test");
        
        report=new ExtentReports();
        report.attachReporter(htmlReport);
        report.setSystemInfo("TestURL", "http://localhost:8888/");
        report.setSystemInfo("Platform", "Windows 10");
        report.setSystemInfo("Reporter Name", "keshav");
	}
	@BeforeTest
	public void configBT() {
		//parallel execution
		System.out.println("Execute in parallel mode");
	}
	@BeforeClass
	public void configBC() {
		//launch the browser
		System.out.println("Launch the browser");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		sDriver=driver;
	}
	@BeforeMethod
	public void setUp(ITestResult result) {
		//Log into application
		System.out.println("Log into Application");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Take Screenshot "+result.getMethod().getMethodName());
			test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
	        test.log(Status.FAIL, result.getThrowable());
			try {
				String path = webLibrary.takeScreenshot(BaseClassForExtent.sDriver,result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(path);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
		    test.log(Status.SKIP, result.getThrowable());
		}
		System.out.println("Logout the Application");
	}
	@AfterClass
	public void configAC() {
		//close the browser
		System.out.println("Close the browser");
		driver.quit();
	}
	@AfterTest
	public void configAT() {
		//close browser launched in parallel
		System.out.println("Excuted sucessfully");
	}
	@AfterSuite
	public void configAS() {
		//close db
		System.out.println("close database");
		report.flush();
	}
}
