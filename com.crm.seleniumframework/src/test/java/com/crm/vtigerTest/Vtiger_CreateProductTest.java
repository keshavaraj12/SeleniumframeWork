package com.crm.vtigerTest;

import org.testng.annotations.Test;
import com.crm.generic_utilitie.BaseClass;
import com.crm.generic_utilitie.Exel_Utility;
import com.crm.generic_utilitie.Java_Utility;
import com.crm.pomrepositary.HomePage;
import com.crm.pomrepositary.ProductsPage;

public class Vtiger_CreateProductTest extends BaseClass{
	@Test(groups= {"smokeTest","regressionTest"})
	public void createProductTest() throws Throwable {
		Java_Utility javalibrary=new Java_Utility();
		Exel_Utility exelLibrary=new Exel_Utility();
		
		HomePage home=new HomePage(driver);
		home.ClickProductsModule();
		
		int ranNum = javalibrary.getRandomNumber(1000);
		System.out.println("ranNum="+ranNum);
		String cellsheet = exelLibrary.readStringDataFromExcel("sheet1",0,0)+ranNum;
		
		ProductsPage product=new ProductsPage(driver);
		product.productpage(cellsheet);
		product.clickonsavebutton();
		product.ProductVerification(cellsheet);
		product.deleteProduct(driver);
		    
		home.signout();
	}
}
