package com.crm.contacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactWithOrganization {
public static void main(String[] args) throws Throwable {
	String key="webdriver.chrome.driver";
	String value="./src/main/resources/chromedriver.exe";
	System.setProperty(key, value);
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
	
	FileInputStream fis=new FileInputStream("./src/test/resources/commondata1.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String URL = pobj.getProperty("url");
	String username = pobj.getProperty("un");
	String password = pobj.getProperty("pwd");
	//System.out.println(username);
	//System.out.println(password);
	
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	driver.findElement(By.id("submitButton")).submit();
	
	Random ran=new Random();
	FileInputStream fis1 = new FileInputStream("C:\\Users\\HP\\Desktop\\Worksheet.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	Sheet sheet=workbook.getSheet("sheet1");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String cellsheet = cell.getStringCellValue()+ran;
	String cellsheet1 = cell.getStringCellValue();
	
	driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//td[@style='padding-right:0px;padding-left:10px;']//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(cellsheet);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(cellsheet1);
	
	//driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
	WebElement img = driver.findElement(By.xpath("//img[@alt='Select']"));
	wait.until(ExpectedConditions.visibilityOf(img)).click();
	Thread.sleep(5000);
	String parent = driver.getWindowHandle();
	Set<String> id = driver.getWindowHandles();
	System.out.println("id="+id);
	
	for (String wid : id) {
		System.out.println("wid="+wid);
		String eachtitle = driver.switchTo().window(wid).getTitle();
		System.out.println("eachtitle="+eachtitle);
		if (eachtitle.contains("Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM"))
		{
		 continue;    
		}
		else
		{
			System.out.println("create org");
			driver.findElement(By.xpath("//table[@class='small']//a[@id='1']")).click();
		}
		driver.switchTo().window(parent);
	}
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(4000);
	
	String ContName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println("ContName= "+ContName);
	if(ContName.contains(cellsheet))
	{
		System.out.println("Created contact_info is sucussfully");
	}else {
		System.out.println("Created contact_info is unsucussfully");
	}
	
	
	
	driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
	Alert al = driver.switchTo().alert();
	al.accept();
    System.out.println("delete sucussfully");
    
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	Thread.sleep(3000);
	driver.quit();
}
}
