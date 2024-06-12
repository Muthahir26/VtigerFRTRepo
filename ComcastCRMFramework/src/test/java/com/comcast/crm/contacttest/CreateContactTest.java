package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {
	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactTest() throws Throwable {

		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actHeader = cip.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		// verify header msg Expected result
		String actLastName = cip.getLastNameEdt().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actLastName, lastName);
		
//		if (actLastName.contains(lastName)) {
//			System.out.println(lastName + " is verified==>Pass");
//		} else {
//			System.out.println(lastName + " is not verified==>Fail");
//		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		// verify start date
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " is verified==>Pass");
		} else {
			System.out.println(startDate + " is not verified==>Fail");
		}
		// verify end date
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " is verified==>Pass");
		} else {
			System.out.println(endDate + " is not verified==>Fail");
		}

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify header msg Expected result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " Information is created==>Pass");
		} else {
			System.out.println(orgName + " Information is not created==>Fail");
		}

		// navigate to contact module
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.getSelectOrg().click();

		wLib.switchToTabOnURL(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wLib.switchToTabOnURL(driver, "Contacts&action");
		ccp.createContactWithOrg(contactLastName, orgName);
		Thread.sleep(3000);
		// verify header msg Expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerInfo = cip.getHeaderMsg().getText();
		if (headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName + " last Name is verified==>Pass");
		} else {
			System.out.println(contactLastName + " last Name is verified==>Fail");
		}
		// verify header orgName info Expected Result
		actOrgName = cip.getActOrgName().getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " Information is created==>Pass");
		} else {
			System.out.println(orgName + " Information is not created==>Fail");
		}

	}
}
