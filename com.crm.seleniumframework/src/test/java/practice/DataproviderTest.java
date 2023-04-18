package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {
	@Test(dataProvider = "dataProvider_test")
public void companyDetails(String name,String sponsorname,String size ) throws Throwable {
	String key="webdriver.chrome.driver";
	String value="./src/main/resources/chromedriver.exe";
	System.setProperty(key, value);
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).submit();
	
	driver.findElement(By.xpath("//a[.='More']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[.='Campaigns']")).click();
	driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']//a//img[@title='Create Campaign...']")).click();
	driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(name);
	driver.findElement(By.id("sponsor")).sendKeys(sponsorname);
	driver.findElement(By.id("targetsize")).sendKeys(size);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.quit();
	Thread.sleep(2000);
}
	
@DataProvider
public Object[][] dataProvider_test(){
	Object[][] objArr=new Object[3][3];
	objArr[0][0]="raju";
	objArr[0][1]="ramu";
	objArr[0][2]="5";
	
	objArr[1][0]="rajesh";
	objArr[1][1]="ramesh";
	objArr[1][2]="10";
	
	objArr[2][0]="rakesh";
	objArr[2][1]="ramaraju";
	objArr[2][2]="10";
	
	return objArr;
}
}
