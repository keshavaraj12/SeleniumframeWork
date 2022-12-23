package extentReportCreation;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic_utilitie.BaseClass;



public class ItestlistenerIMP implements ITestListener{
	 ExtentReports report;
	 ExtentTest test;
	@Override		
   public void onFinish(ITestContext arg0) {					
      	report.flush();		
       		
   }		

   @Override		
   public void onStart(ITestContext arg0) {	
	   String timeStamp = LocalDateTime.now().toString().replace(':', '-');
       ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File(".\\ExtentReport\\report"+timeStamp+".html"));
       htmlReport.config().setDocumentTitle("Extent Report");
       htmlReport.config().setTheme(Theme.DARK);
       htmlReport.config().setReportName("Functional Test");
       
        report=new ExtentReports();
       report.attachReporter(htmlReport);
       report.setSystemInfo("TestURL", "http://localhost:8888/");
       report.setSystemInfo("Platform", "Windows 10");
       report.setSystemInfo("Reporter Name", "Keshava");
	   
   }		

   @Override		
   public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
       // TODO Auto-generated method stub				
       		
   }		

   @Override		
   public void onTestFailure(ITestResult result) {					
//       test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
//       test.log(Status.FAIL, result.getThrowable());
//		try {
//			String path = WebDriverUtiity.takeScreenshot(BaseClass.sdriver, result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(path);
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	   String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		String testname = result.getMethod().getMethodName();
		System.out.println(testname+"Take ScreenShot");	
		EventFiringWebDriver pdriver=new EventFiringWebDriver(BaseClass.sdriver);
		File srcfile=pdriver.getScreenshotAs(OutputType.FILE);
		try {
			File destfile=new File("./ScreenShots/"+timeStamp+"+"+testname+".png");
			FileUtils.copyFile(srcfile, destfile);
		} catch (Throwable e) {
			e.printStackTrace();
		}
       		
   }		

   @Override		
   public void onTestSkipped(ITestResult result) {					
      test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
      test.log(Status.SKIP, result.getThrowable());	
   }		

   @Override		
   public void onTestStart(ITestResult result) {					
      test=report.createTest(result.getMethod().getMethodName());				
       		
   }		

   @Override		
   public void onTestSuccess(ITestResult arg0) {					
      test.log(Status.PASS, arg0.getMethod().getMethodName()+" is passed");			
       		
   }
}
