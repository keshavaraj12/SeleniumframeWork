package practice;

import org.testng.annotations.Test;

public class Sample1 {
@Test
public void createCustomerTest() {
	System.out.println("customer details created");
}
@Test(dependsOnMethods ="deleteCustomerTest" )
public void modifyCustomerTest() {
	System.out.println("customer details modified");
}
@Test
public void deleteCustomerTest() {
	System.out.println("customer details delete");
}
}
