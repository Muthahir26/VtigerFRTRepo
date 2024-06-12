package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver; 
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name ="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath ="//input [@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name ="industry")
	private WebElement industryDD;
	
	@FindBy(name ="accounttype")
	private WebElement typeDD;
	
	@FindBy(id ="phone")
	private WebElement phnumberEdt;
	
	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName ) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName, String industry ) {
		Select s=new Select(industryDD);
		s.selectByVisibleText(industry);
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName, String industry,String type) {
		orgNameEdt.sendKeys(orgName);
		Select s1=new Select(industryDD);
        s1.selectByVisibleText(industry);
        Select s2=new Select(typeDD);
        s2.selectByVisibleText(type);
        saveBtn.click();
}
	public void createOrgWithPhNumber(String orgName, String phNumber) {
		orgNameEdt.sendKeys(orgName);
		phnumberEdt.sendKeys(phNumber);
        saveBtn.click();
}
	}
