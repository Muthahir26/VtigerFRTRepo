package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrg {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		String Browser = flib.getDataFromPropertyFile("browser");
		String Url = flib.getDataFromPropertyFile("url");
		String UnName = flib.getDataFromPropertyFile("un");
		String PassWord = flib.getDataFromPropertyFile("pw");

		String orgName = eLib.getDataFromExcel("org",10, 2)+jLib.getRandomNumber();

		WebDriver driver=null;

		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.get(Url);

		LoginPage lp= new LoginPage(driver);

		wLib.waitForPageToLoad(driver);

		lp.loginToApp(UnName, PassWord);

		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

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
		if(actOrgName.equals(orgName)) {
			System.out.println(orgName+" Information name is created==>Pass");
		}
		else {
			System.out.println(orgName+" Information name is not created==>Fail");
		}
		//go back to org page
		hp.getOrgLink().click();
		//search for org
		op.getSearchEdt().sendKeys(orgName);
		
		wLib.select(op.getSearchDD(), "Organization Name");
		op.getSearchBtn().click();
		
		//in dynamic web table select and delete org
		driver.findElement(By.xpath("//a [text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		driver.switchTo().alert().accept();
		//logout
		hp.logOut();
		driver.quit();
	}
}
