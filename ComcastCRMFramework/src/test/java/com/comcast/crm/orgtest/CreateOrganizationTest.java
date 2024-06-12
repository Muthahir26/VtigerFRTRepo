package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {
    @Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
    	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");

    	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Create a new org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+"===>Create a new Org<===");
		//verify header msg Expected result

		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String headerInfo= oip.getHeaderMsg().getText();

		if(headerInfo.contains(orgName)) {
			System.out.println(orgName+" header is verified==>Pass");
		}
		else {
			System.out.println(orgName+" header is not verified==>Fail");
		}

		//verify header orgName info Expected Result

		String actOrgName = oip.getActOrgName().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
//		if(actOrgName.equals(orgName)) {
//			System.out.println(orgName+" Information name is created==>Pass");
//		}
//		else {
//			System.out.println(orgName+" Information name is not created==>Fail");
//		}
	}
    @Test(groups = "regressionTest")
   	public void createOrganizationWithPhoneNumber() throws Throwable {

   		String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
   		String phnumber = eLib.getDataFromExcel("org", 7, 3);
   		
   		HomePage hp=new HomePage(driver);
   		hp.getOrgLink().click();

   		OrganizationsPage op=new OrganizationsPage(driver);
   		op.getCreateNewOrgBtn().click();
   		
           CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
           cop.createOrgWithPhNumber(orgName, phnumber);
   		
           //verify header phone number info Expected Result
           OrganizationInformationPage oip=new OrganizationInformationPage(driver);
           String actPhNumber = oip.getActPhNumber().getText();
           System.out.println(actPhNumber);
       	System.out.println(phnumber);
           if(actPhNumber.trim().equals(phnumber)) {
        	   System.out.println(phnumber+" Information is created==>Pass");
           }
           else {
        	   System.out.println(phnumber+" Information is not created==>Fail");
           }
            	}
    @Test(groups = "regressionTest")
	public void createOrganizationWithIndustries() throws Throwable {

		String orgName = eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
        CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
        cop.createOrg(orgName, industry, type);
        
        //verify industry msg Expected result
        OrganizationInformationPage oip=new OrganizationInformationPage(driver);
        String actIndustries = oip.getActIndustryDD().getText();
       if(actIndustries.trim().equals(industry)) {
    	   System.out.println(industry+" is verified==>Pass");
       }
       else {
    	   System.out.println(industry+" is not verified==>Fail");
       }
       //verify type info Expected Result
       String actType=oip.getActTypeDD().getText();
       if(actType.equals(type)) {
    	   System.out.println(type+" Information is verified==>Pass");
       }
       else {
    	   System.out.println(type+" Information is not verified==>Fail");
       }
	}
   
}
