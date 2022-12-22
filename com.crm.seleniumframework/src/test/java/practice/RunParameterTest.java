package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunParameterTest {
	public WebDriver driver;
	@Test
public void parametermethodTest() {
		 
		String Browser = System.getProperty("browser");
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
		
		String URL = System.getProperty("url");
		driver.get(URL);
		
		String Username = System.getProperty("username");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		
		String Password = System.getProperty("password");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		
		driver.findElement(By.id("submitButton")).submit();
		
		driver.quit();
}
}
