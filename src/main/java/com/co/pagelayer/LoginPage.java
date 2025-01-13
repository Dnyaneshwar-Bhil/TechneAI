package com.co.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.co.utils.MasterClass;

public class LoginPage extends MasterClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_id")
	private WebElement username;

	public WebElement username() {
		return username;
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement password() {
		return password;
	}

	@FindBy(xpath = "//button[text()='SIGN IN']")
	private WebElement clickOnsignInBtn;

	public WebElement clickOnsignInBtn() {
		return clickOnsignInBtn;
	}
	
	@FindBy(xpath = "//button[text()='Continue to site']")
	private WebElement clickOnContinueToSite;

	public WebElement clickOnContinueToSite() {
		return clickOnContinueToSite;
	}
	
	// Dashboard : TC1

	@FindBy(xpath = "//li[2]//a[1]//span[2]")
	private WebElement clickOnMenuMaster;

	public WebElement clickOnMenuMaster() {
		return clickOnMenuMaster;
	}

	@FindBy(xpath = "//a[normalize-space()='Customer Master']")
	private WebElement clickOnMenuCustomerMaster;

	public WebElement clickOnMenuCustomerMaster() {
		return clickOnMenuCustomerMaster;
	}

	@FindBy(xpath = "//a[normalize-space()='Add Customer']")
	private WebElement clickOnAddCustomer;

	public WebElement clickOnAddCustomer() {
		return clickOnAddCustomer;
	}

	@FindBy(xpath = "//h5[normalize-space()='Customer Details']")
	private WebElement isCustomerDetailsTextDisplayed;

	public WebElement isCustomerDetailsTextDisplayed() {
		return isCustomerDetailsTextDisplayed;
	}
	
	
	// TC3
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement txtCustomerName;

	public WebElement txtCustomerName() {
		return txtCustomerName;
	}
	
	@FindBy(xpath = "(//input[contains(@id,'react-select')])[1]")
	private WebElement txtCustomerType;

	public WebElement txtCustomerType() {
		return txtCustomerType;
	}
	//input[@id='react-select-3-input']
	
	@FindBy(xpath = "//input[@id='email_id']")
	private WebElement txtEmail;

	public WebElement txtEmail() {
		return txtEmail;
	}
	
	@FindBy(xpath = "//input[@id='contact_no']")
	private WebElement txtContactNo;

	public WebElement txtContactNo() {
		return txtContactNo;
	}
	
	@FindBy(xpath = "//input[@id='pincode']")
	private WebElement txtPinCode;

	public WebElement txtPinCode() {
		return txtPinCode;
	}
	
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement txtAddress;

	public WebElement txtAddress() {
		return txtAddress;
	}
	// ---------- Country, State, City -------------
	@FindBy(xpath = "//input[contains(@id,'react-select-3-input')]")
	private WebElement txtCountry;

	public WebElement txtCountry() {
		return txtCountry;
	}
	
	@FindBy(xpath = "//input[contains(@id,'react-select-4-input')]")
	private WebElement txtState;

	public WebElement txtState() {
		return txtState;
	}
	
	@FindBy(xpath = "//input[contains(@id,'react-select-5-input')]")
	private WebElement txtCity;

	public WebElement txtCity() {
		return txtCity;
	}
	
	//----------------------------
	
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement btnSubmit;

	public WebElement btnSubmit() {
		return btnSubmit;
	}
}
