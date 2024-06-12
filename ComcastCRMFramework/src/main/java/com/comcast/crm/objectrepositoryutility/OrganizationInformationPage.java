package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver; 
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(className ="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id ="dtlview_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(id ="dtlview_Type")
	private WebElement actTypeDD;
	
	@FindBy(id ="dtlview_Industry")
	private WebElement actIndustryDD;
	
	@FindBy(id ="mouseArea_Phone")
	private WebElement actPhNumber;
	
	public WebElement getActPhNumber() {
		return actPhNumber;
	}

	public WebElement getActIndustryDD() {
		return actIndustryDD;
	}

	public WebElement getActTypeDD() {
		return actTypeDD;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	
}
