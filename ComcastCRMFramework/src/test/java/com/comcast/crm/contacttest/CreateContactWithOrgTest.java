package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws InterruptedException, Throwable {

		String orgName = eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();

		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		//verify header msg Expected result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName+" Information is created==>Pass");
		}
		else {
			System.out.println(orgName+" Information is not created==>Fail");
		}

		// navigate to contact module
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();
		
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		ccp.getSelectOrg().click();

		wLib.switchToTabOnURL(driver, "module=Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wLib.switchToTabOnURL(driver, "Contacts&action");
		ccp.createContactWithOrg(contactLastName, orgName);
		Thread.sleep(3000);
		//verify header msg Expected result
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerInfo = cip.getHeaderMsg().getText();
		System.out.println(headerInfo);
		System.out.println(contactLastName);
		if(headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName+" last Name is verified==>Pass");
		}
		else {
			System.out.println(contactLastName+" last Name is verified==>Fail");
		}
		//verify header orgName info Expected Result
		actOrgName=cip.getActOrgName().getText();
		System.out.println(actOrgName);
		System.out.println(orgName);
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName+" Information is created==>Pass");
		}
		else {
			System.out.println(orgName+" Information is not created==>Fail");
		}
	}

}
