package practice.test;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName()+" Test Start ");
		Reporter.log(null);
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log(mtd.getName()+" Test End ");
	}
	@Test
	public void verifyHomePageLogoTest(Method mtd) {
		Reporter.log(mtd.getName()+" Test Start ");
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log(mtd.getName()+" Test End ");
	}
}
