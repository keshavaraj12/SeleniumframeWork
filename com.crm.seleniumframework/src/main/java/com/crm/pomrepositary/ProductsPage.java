package com.crm.pomrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic_utilitie.WebDriver_Utility;

public class ProductsPage {
	//intialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath ="//td[@style='padding-right:0px;padding-left:10px;']//a//img[@title='Create Product...']")
	private WebElement ClickOnCreateProduct;
	
	@FindBy(xpath ="//input[@name='productname']")
	private WebElement ProductName;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement ClickOnSavebutton;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement ProductTextName;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement DeleteProduct;
	
	//getter method
	public WebElement getClickOnCreateProduct() {
		return ClickOnCreateProduct;
	}
	
	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getClickOnSavebutton() {
		return ClickOnSavebutton;
	}
	
	public WebElement getProductTextName() {
		return ProductTextName;
	}
	
	public WebElement getDeleteProduct() {
		return DeleteProduct;
	}
	

	//Business logic method
	public void productpage(String name) {
		ClickOnCreateProduct.click();
		ProductName.sendKeys(name);
	}
	
	public void clickonsavebutton() {
		ClickOnSavebutton.click();
	}
	
	public void ProductVerification(String cellsheet) {
		String ProdName = ProductTextName.getText();
		System.out.println("ProdName= "+ProdName);
		if(ProdName.contains(cellsheet))
		{
			System.out.println("Created Product_info is sucussfully");
		}else {
			System.out.println("Created Product_info is unsucussfully");
		}
	}
	
 WebDriver_Utility webLibrary=new WebDriver_Utility();
	public void deleteProduct(WebDriver driver) {
		DeleteProduct.click();
		webLibrary.useAlertAccept(driver);
	    System.out.println("delete sucussfully");
	}
}
