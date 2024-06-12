package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver; 
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(className ="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id ="dtlview_Last Name")
	private WebElement lastNameEdt;
	
	@FindBy(id ="mouseArea_Organization Name")
	private WebElement actOrgName;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}
}
