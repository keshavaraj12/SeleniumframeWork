package extentReportCreation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.BaseClassForExtent;

public class Testcaseforbase extends BaseClassForExtent{
	@Test
	public void testcasebase() {
		
		driver.findElement(By.name("user_name")).sendKeys("Admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		Assert.assertTrue(false);
		
		SoftAssert soft=new SoftAssert();
		soft.assertAll();
	}

}
