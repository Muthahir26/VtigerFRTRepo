package com.comcast.crm.basetest;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("===>Connect to DB , Report Config<===");
		dLib.getDbConnection();
	
	}
//	@Parameters("Browser")
//	@BeforeClass(groups = {"smokeTest","regressionTest"})
//	public void configBC(String browser) throws Throwable
	@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("===>Open browser, Report Config<===");
		//String Browser=fLib.getDataFromPropertyFile("browser");//String Browser= browser -( if parameterized)
		String Browser=System.getProperty("browser",fLib.getDataFromPropertyFile("browser"));
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
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		System.out.println(sdriver.getTitle());
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		String URL=System.getProperty("url",fLib.getDataFromPropertyFile("url"));
		String USERNAME=System.getProperty("username",fLib.getDataFromPropertyFile("un"));
		String PASSWORD=System.getProperty("password",fLib.getDataFromPropertyFile("pw"));
//		String URL=fLib.getDataFromPropertyFile("url");
//		System.out.println("===>login Vtiger, Report Config<===");
//		String USERNAME=fLib.getDataFromPropertyFile("un");
//		String PASSWORD=fLib.getDataFromPropertyFile("pw");
		LoginPage lp=new LoginPage(driver);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		lp.loginToApp(URL, USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		HomePage hp=new HomePage(driver);
		System.out.println("===>Inside after method ,Report Config<===");
		hp.logOut();
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("===>Close Browser ,Report Config<===");
		driver.quit();
	}
	@AfterSuite	(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===>Disconnect from DB , Report Config<===");
		dLib.closeConnection();
		
	}
}
