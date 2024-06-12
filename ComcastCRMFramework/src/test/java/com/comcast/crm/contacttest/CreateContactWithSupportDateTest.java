package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {
    @Test
	public void createContactWithSupportDateTest() throws Throwable {

		String lastName = eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
		
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		//verify start date
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.equals(startDate)) {
			System.out.println(startDate+" is verified==>Pass");
		}
		else {
			System.out.println(startDate+" is not verified==>Fail");
		}
		//verify end date
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
	
		if(actEndDate.equals(endDate)) {
			System.out.println(endDate+" is verified==>Pass");
		}
		else {
			System.out.println(endDate+" is not verified==>Fail");
		}
	}

}
