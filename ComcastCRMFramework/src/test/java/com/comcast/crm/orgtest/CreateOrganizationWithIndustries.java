package com.comcast.crm.orgtest;

import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithIndustries extends BaseClass {
	@Test
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
