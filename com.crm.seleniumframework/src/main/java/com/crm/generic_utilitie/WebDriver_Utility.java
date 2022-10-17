package com.crm.generic_utilitie;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	public WebDriver driver;
	
		/*
		 This method used to Sychronize the element in Dom
		  */
		public void useImplicitWait(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}
		
		/*
		 This method used to Sychronize the each expected element
		 */
		public void useExplicitWaitforvisible(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void useExplicitWaitforclick(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/*
		 This method used to pre-condition in script for maximize the window
		 */
		public void useMaximize(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		/*
		 This method used to post-condition in script for minimize the window
		 */
		public void useMinimize(WebDriver driver) {
			driver.manage().window().minimize();
		}
		
		/*
		  This method used to get the window id of parent window
		 */
		public void usegetWindowHandle(WebDriver driver) {
			driver.getWindowHandle();
		}
		
		/*
		  This method used to get the window id of parent window and child window
		 */
		public void usegetWindowHandles(WebDriver driver) {
			driver.getWindowHandles();
		}
		
		public void switchToWindow(WebDriver driver,String PartialWindowTitle)
		{
			  Set<String> allId = driver.getWindowHandles();
		      Iterator<String> it=allId.iterator();
		      while(it.hasNext())
		      {
		      	String wid = it.next();
		      	driver.switchTo().window(wid);
		      	if(driver.getTitle().contains(PartialWindowTitle))
		      	{
		      		break;
		      	}
		}}
		
		/*
		 This method used dropdown element to get all options 
		 */
		public void useSelect(WebElement element) {
			Select selt=new Select(element);
			selt.getOptions();
		}
		
		public void useAlertAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		public void useAlertDismis(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		public void useAlertSendkeys(WebDriver driver,String keys) {
			driver.switchTo().alert().sendKeys(keys);
		}
		public void useAlertAcceptGettext(WebDriver driver) {
			driver.switchTo().alert().getText();
		}
		
		public void framebyindex(int index){
			driver.switchTo().frame(index);
		}
		public void framebystring(String name){
			driver.switchTo().frame(name);
		}
		public void framebyelement(WebElement element){
			driver.switchTo().frame(element);
		}
		
		public void useAction(WebDriver driver,WebElement element) {
			Actions act=new Actions(driver);
			//act.click().perform();
			act.click(element);
		}
		/*
		 * This method is used to quit the browser
		 */
		public void useQuit(WebDriver driver) {
			driver.quit();
		}
}
