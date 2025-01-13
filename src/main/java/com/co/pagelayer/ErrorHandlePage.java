package com.co.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.co.utils.MasterClass;

public class ErrorHandlePage extends MasterClass {

	public ErrorHandlePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//small[normalize-space()='Customer Type is required']")
	private WebElement errorcustomerType;

	public WebElement errorcustomerType() {
		return errorcustomerType;
	}
	
	
	@FindBy(xpath = "//small[@class='text-danger']")
	private WebElement errorPinCode;

	public WebElement errorPinCode() {
		return errorPinCode;
	}
		
	@FindBy(xpath = "//div[@class='Toastify']")
	private WebElement toastifyMessage;

	public WebElement toastifyMessage() {
		return toastifyMessage;
	}
}
