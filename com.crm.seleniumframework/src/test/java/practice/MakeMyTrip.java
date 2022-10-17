
package practice;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
public static void main(String[] args) throws Throwable {
	String key="webdriver.chrome.driver";
	String value="./chromedriver.exe";
	System.setProperty(key, value);
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	FileInputStream fis=new FileInputStream("./commondata1.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String URL = pobj.getProperty("url1");
	
	//Random ran=new Random();
	FileInputStream fis1 = new FileInputStream("C:\\Users\\HP\\Desktop\\Worksheet.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	String cellValue = workbook.getSheet("sheet1").getRow(0).getCell(1).getStringCellValue();
	String cellValue1 = workbook.getSheet("sheet1").getRow(0).getCell(2).getStringCellValue();
	System.out.println("cellValue="+cellValue);
	System.out.println("cellValue1="+cellValue1);

	driver.get(URL);
	//from location
	driver.findElement(By.xpath("//div[@class='fsw_inner returnPersuasion']//label[@for='fromCity']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(cellValue);
	Thread.sleep(2000);
	driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//ul[@role='listbox']//li//div[@class='makeFlex hrtlCenter']")).get(0).click();
	
	//to location
	driver.findElement(By.xpath("//div[@class='fsw_inner returnPersuasion']//label[@for='toCity']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(cellValue1);
	Thread.sleep(2000);
	driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//ul[@role='listbox']//li//div[@class='makeFlex hrtlCenter']")).get(0).click();
	
	driver.findElement(By.xpath("//div[@class='langCard  fixedCard bounceAni']//span[@class='langCardClose']")).click();
	
	//departure
	/*driver.findElement(By.xpath("//div[@class='fsw_inner returnPersuasion']//label[@for='departure']")).click();
	Thread.sleep(2000);
	String month ="October";
	String date="12";
	//div[.='October 2022']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[.='12']
	//div[@class='DayPicker-Caption']//div[text()='October']/../..//p[.='12']
	//driver.findElement(By.xpath("//div[.='"+month+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
	//driver.findElement(By.xpath("//div[@class='DayPicker-Caption']//div[text()='"+month+"']/../..//p[.='"+date+"']")).click();*/
	
	//return
	driver.findElement(By.xpath("//span[.='RETURN']")).click();
	Thread.sleep(2000);
	String month1 ="October";
	String date1="30";
	driver.findElement(By.xpath("//div[@class='DayPicker-Caption']//div[text()='"+month1+"']/../..//p[.='"+date1+"']")).click();
	
	
	//travellers
	driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom5']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[.='ADULTS (12y +)']/..//ul//li[@data-cy='adults-3']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[.='CHILDREN (2y - 12y )']/..//ul//li[@data-cy='children-1']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[.='INFANTS (below 2y)']/..//ul//li[@data-cy='infants-1']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[.='APPLY']")).click();
	Thread.sleep(3000);
	driver.quit();
}
}
