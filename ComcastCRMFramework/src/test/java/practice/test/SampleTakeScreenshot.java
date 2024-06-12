package practice.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTakeScreenshot {
    @Test
	private void amazonTest() throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://amazon.com");
	TakesScreenshot t=(TakesScreenshot) driver;
	File src=t.getScreenshotAs(OutputType.FILE);
	File desc=new File("./screenshot/test.png");
	FileUtils.copyFile(src, desc);
	
	
	
}
}
