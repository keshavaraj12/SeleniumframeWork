package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleDataProvidertest{
	@Test(dataProvider="dataProvider_Test")
	public void bookTicket(String src,String dst) {
		System.out.println("Book titckets from "+src+" to "+dst+"");
	}
	@DataProvider
	public Object[][] dataProvider_Test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Bangaluru";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Bangaluru";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Bangaluru";
		objArr[2][1]="Mangaluru";
		
		objArr[3][0]="Bangaluru";
		objArr[3][1]="Chenai";
		
		objArr[4][0]="Bangaluru";
		objArr[4][1]="Mumbai";
		
		return objArr;	
	}
}
