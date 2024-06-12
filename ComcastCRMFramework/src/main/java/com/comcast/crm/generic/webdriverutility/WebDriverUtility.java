package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		for(String wh:set)
		{
			driver.switchTo().window(wh);
			String currentURL = driver.getCurrentUrl();
			if(currentURL.contains(partialURL)) {
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		for(String wh:set)
		{
			driver.switchTo().window(wh);
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle)) {
				break;
			}
		}}
	public void switchToframe(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	//name or attribute to switch
	public void switchToframe(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchToframe(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
}
	public void select(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
}
