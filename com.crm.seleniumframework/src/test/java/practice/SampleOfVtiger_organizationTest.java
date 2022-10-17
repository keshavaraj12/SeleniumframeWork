package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.HomePage;
import com.crm.pomrepositary.OrganizationsPage;
@Listeners(com.crm.generic_utilitie.Listener.class)
public class SampleOfVtiger_organizationTest extends BaseClass{
	//@Test(retryAnalyzer =com.crm.generic_utilitie.RetryAnalyser.class )
		@Test
		public  void createorganization() throws Throwable {
			Java_Utility javalibrary=new Java_Utility();
			Exel_Utility exelLibrary=new Exel_Utility();
			
			HomePage home=new HomePage(driver);
			home.ClickOrganizationsModule();
			
			int ranNum = javalibrary.getRandomNumber(1000);
			System.out.println("ranNum="+ranNum);
			String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,1)+ranNum;
			System.out.println("cellsheet= "+cellsheet);
			
			OrganizationsPage organization=new OrganizationsPage(driver);
			organization.organizationpage(cellsheet);
			
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(true, true);
			
			organization.clickonsavebutton();
			organization.organizationpageVerification(cellsheet);
		    organization.deleteOrganization(driver);
		    
		    home.signout();
		    
		    soft.assertAll();
		}
}
