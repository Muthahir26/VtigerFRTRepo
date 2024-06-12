package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleInvoiceTest {
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListener.class)
	public void createSimTest() {
		System.out.println("execute createInvoiceTest");
		//Assert.assertEquals("","Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
}}
