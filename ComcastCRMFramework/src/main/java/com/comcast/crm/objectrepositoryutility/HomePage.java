package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver; 
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText ="Organizations")
	private WebElement orgLink;

	@FindBy(linkText ="Contacts")
	private WebElement contactLink;

	@FindBy(linkText ="More")
	private WebElement moretLink;

	@FindBy(linkText ="Campaigns")
	private WebElement campaignLink;

	@FindBy(xpath ="//img [@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText ="Sign Out")
	private WebElement signOutLink;

	@FindBy(linkText ="Products")
	private WebElement productsLink;
	
	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getMoretLink() {
		return moretLink;
	}
	public WebElement getCampaignLink() {
		return campaignLink;
	}
	public void navigateToCampaignPage() {
		Actions a=new Actions(driver);
		a.moveToElement(moretLink).perform();
		campaignLink.click();
	}
	public void logOut() {
		Actions a=new Actions(driver);
		a.moveToElement(adminImg).perform();
		signOutLink.click();
		System.out.println("Log out");
	}
}
