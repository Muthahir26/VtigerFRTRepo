package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

//Rule 1 : Create separate java class
public class LoginPage extends WebDriverUtility {
	WebDriver driver; 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//Rule 2: Object creation
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input [@type='submit']")})
	private WebElement loginBtn;
	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void loginToApp(String username,String password) {
		driver.manage().window().maximize();
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	public void loginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
