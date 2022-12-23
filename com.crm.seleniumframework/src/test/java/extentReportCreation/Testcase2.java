package extentReportCreation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.generic_utilitie.BaseClass;

public class Testcase2 extends BaseClass{
	@Test
	public void testcase2() {
		
		driver.findElement(By.name("user_name")).sendKeys("Admin");
		
		driver.findElement(By.name("user_password")).sendKeys("manager");
		Assert.assertTrue(false);
//		SoftAssert soft=new SoftAssert();
//		soft.assertTrue(false);
//		soft.assertAll();
	}

}
