package practice.test;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+" Test Start ");
		String expTitle="Home";

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).submit();
		String actTitle = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		Assert.assertEquals(expTitle, actTitle);

		System.out.println(mtd.getName()+" Test End ");
		driver.quit();
	}
	@Test
	public void verifyHomePageLogoTest(Method mtd) {
		System.out.println(mtd.getName()+" Test Start ");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).submit();
		boolean status = driver.findElement(By.xpath("//img [@title='vtiger-crm-logo.gif']")).isEnabled();
		Assert.assertEquals(true, status);
		Assert.assertTrue(status);
		

		System.out.println(mtd.getName()+" Test End ");
		driver.quit();
	}
}

