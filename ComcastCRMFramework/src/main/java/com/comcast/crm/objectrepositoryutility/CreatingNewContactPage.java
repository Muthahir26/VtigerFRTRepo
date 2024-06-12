package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver; 
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input [@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement endDateEdt;
	
	@FindBy(name="account_name")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input [@name='account_name']/following-sibling::img")
	private WebElement selectOrg;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getSelectOrg() {
		return selectOrg;
	}
	
	public WebElement getStartDateEdt() {
		return startDateEdt;
	}
	public WebElement getEndDateEdt() {
		return endDateEdt;
	}
	
	public WebElement getLastName() {
		return lastNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createContactWithSupportDate(String lastName, String startDate, String endDate) {
		lastNameEdt.clear();
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}
	public void createContactWithOrg(String contactLastName,String orgName ) {
		lastNameEdt.sendKeys(contactLastName);
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
}
