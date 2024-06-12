package practice.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {

	@Test(dataProvider = "getData")
	public void createContact(String firstName, String lastName, long phoneNumber) {
		System.out.println("First Name : "+firstName + ",Last Name : "+ lastName +",Phone Number : "+phoneNumber);
	}
	@DataProvider
	public Object[][] getData() {
		Object [][] obj=new Object[3][3];
		obj[0][0]="Deepak";
		obj[0][1]="H.R";
		obj[0][2]=54541515121l;
		obj[1][0]="Sam";
		obj[1][1]="S.H";
		obj[1][2]=98765432510l;
		obj[2][0]="John";
		obj[2][1]="smith";
		obj[2][2]=98765432510l;
		return obj;
	}
}
