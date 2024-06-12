package com.comcast.crm.orgtest;

import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPhoneNumber extends BaseClass {
    @Test
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
        if(actPhNumber.trim().equals(phnumber)) {
     	   System.out.println(phnumber+" Information is created==>Pass");
        }
        else {
     	   System.out.println(phnumber+" Information is not created==>Fail");
        }
         	}

}
