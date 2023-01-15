package extentReportCreation;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@Test
	public void extenreport() {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	    ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File(".\\ExtentReport\\report ["+timeStamp+"] .html"));
	    htmlReport.config().setDocumentTitle("Extent Report");
	    htmlReport.config().setTheme(Theme.STANDARD);
	    htmlReport.config().setReportName("Functional Test");
	    
	    report=new ExtentReports();
	    report.attachReporter(htmlReport);
	    report.setSystemInfo("Platform", "Windows 10");
	    report.setSystemInfo("Reporter Name", "Keshava");  
	    test=report.createTest("ExtentDemo");
	    
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		
		if(driver.getTitle().equals("Google"))
		{
		test.log(Status.PASS, "Navigated to the specified URL-->Test is passed");
		}
		else
		{
		test.log(Status.FAIL, "Test is Failed");
		}
	
		report.flush();
		driver.quit();

	}
}
