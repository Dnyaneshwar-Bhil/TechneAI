package com.co.core;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.co.utils.MasterClass;

public class Login extends MasterClass {
	String customerName = "", customerType = "", email = "", contactNo = "", address = "", country = "", state = "",
			city = "", pincode = "";

	// Error Msg
	String customerTypeErrorMsgExp = "", customerTypeErrorMsgActual = "";
	WebDriver driver;

	public void getDataFromDTO() {
		customerName = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Customer Name"));
		customerType = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Customer Type"));
		email = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Email"));
		contactNo = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Contact Number"));
		address = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Address"));
		country = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Country"));
		state = genericHelper.getValueOrDefault(masterDto.getAttributeValue("State"));
		city = genericHelper.getValueOrDefault(masterDto.getAttributeValue("City"));
		pincode = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Pincode"));

		customerTypeErrorMsgExp = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Expected"));
		customerTypeErrorMsgActual = genericHelper.getValueOrDefault(masterDto.getAttributeValue("Actual"));

	}

	public void TC1(WebDriver driver, String userName, String userPassword) throws InterruptedException, Exception {
		getDataFromDTO();

		loginPage.clickOnContinueToSite().click();

		loginPage.username().sendKeys(userName);

		loginPage.password().sendKeys(userPassword);

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnsignInBtn());

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuCustomerMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnAddCustomer());

		boolean flag = loginPage.isCustomerDetailsTextDisplayed().isDisplayed();
		if (flag) {
			reportHelper.onTestSuccess(test, "TC1 Passed");
			reportHelper.generateLogFullScreenSS(test, "TC1 Passed");
			System.out.println("Customer Dettails Displayed..!!");
		}
	}

	public void TC2(WebDriver driver, String userName, String userPassword) throws InterruptedException, Exception {
		getDataFromDTO();

		loginPage.username().sendKeys(userName);

		loginPage.password().sendKeys(userPassword);

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnsignInBtn());

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuCustomerMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnAddCustomer());

		loginPage.txtCustomerName().sendKeys(customerName);

		genericHelper.clickWithJavascriptExecutor(loginPage.btnSubmit());

		// check error message for customer type
		String msg = errorHandlePage.errorcustomerType().getText();

		System.out.println("TC2 Actual :" + msg);
		System.out.println("TC2 Expected:" + customerTypeErrorMsgExp);

		if (msg.equalsIgnoreCase(customerTypeErrorMsgExp)) {
			reportHelper.onTestSuccess(test, "TC2 Passed");
			reportHelper.generateLogFullScreenSS(test, "");
		}

	}

	// Verify PinCode
	public void TC3(WebDriver driver, String userName, String userPassword) throws InterruptedException, Exception {
		getDataFromDTO();

		loginPage.username().sendKeys(userName);

		loginPage.password().sendKeys(userPassword);

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnsignInBtn());

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuCustomerMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnAddCustomer());

		// fill the form details form DTO
		loginPage.txtCustomerName().sendKeys(customerName);

		loginPage.txtCustomerType().sendKeys("Customer Type B" + Keys.ENTER);

		loginPage.txtEmail().sendKeys(email);

		loginPage.txtContactNo().sendKeys(contactNo);

		loginPage.txtAddress().sendKeys(address);

		loginPage.txtPinCode().sendKeys(pincode);

		loginPage.txtCountry().sendKeys(country + Keys.ENTER);

		loginPage.txtState().sendKeys(state + Keys.ENTER);

		loginPage.txtCity().sendKeys(city + Keys.ENTER);

		// Click On Submit Btn
		genericHelper.clickWithJavascriptExecutor(loginPage.btnSubmit());

		// check error message for customer type
		String msg = errorHandlePage.errorPinCode().getText();

		System.out.println("TC3 Actual :" + msg);
		System.out.println("TC3 Expected:" + customerTypeErrorMsgExp);

		if (msg.equalsIgnoreCase("Pincode must be 6 digits")) {
			reportHelper.onTestSuccess(test, "TC3 Passed");
			reportHelper.generateLogFullScreenSS(test, "");
		}

	}

	// Verify 'Add' Button functionality
	public void TC4(WebDriver driver, String userName, String userPassword) throws InterruptedException, Exception {
		getDataFromDTO();

		loginPage.username().sendKeys(userName);

		loginPage.password().sendKeys(userPassword);

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnsignInBtn());

//		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuMaster());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the element to be clickable
		WebElement menuMasterElement = wait
				.until(ExpectedConditions.elementToBeClickable(loginPage.clickOnMenuMaster()));

		// Use JavaScript executor to click on the element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", menuMasterElement);

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuCustomerMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnAddCustomer());

		// fill the form details form DTO
		loginPage.txtCustomerName().sendKeys(customerName);

		loginPage.txtCustomerType().sendKeys("Customer Type B" + Keys.ENTER);

		loginPage.txtEmail().sendKeys(email);

		loginPage.txtContactNo().sendKeys(contactNo);

		loginPage.txtAddress().sendKeys(address);

		loginPage.txtPinCode().sendKeys(pincode);

		loginPage.txtCountry().sendKeys(country + Keys.ENTER);

		loginPage.txtState().sendKeys(state + Keys.ENTER);

		loginPage.txtCity().sendKeys(city + Keys.ENTER);

		// Click On Submit Btn
		genericHelper.clickWithJavascriptExecutor(loginPage.btnSubmit());

		// check MESSAGE
		String msg = errorHandlePage.toastifyMessage().getText();
		System.out.println("TC4 Actual :" + msg);
		System.out.println("TC4 Expected:" + customerTypeErrorMsgExp);

		if (msg.equalsIgnoreCase("Customer created successfully")) {
			reportHelper.onTestSuccess(test, "TC4 Passed");
			reportHelper.generateLogFullScreenSS(test, "");
		}

	}

	// Verify System throw error while trying to add duplicate data into Customer
	// Name and Customer Type Field.
	public void TC5(WebDriver driver, String userName, String userPassword) throws InterruptedException, Exception {
		getDataFromDTO();

		Thread.sleep(2000);

		loginPage.username().sendKeys(userName);

		loginPage.password().sendKeys(userPassword);

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnsignInBtn());

		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnMenuCustomerMaster());
		genericHelper.clickWithJavascriptExecutor(loginPage.clickOnAddCustomer());

		// fill the form details form DTO
		loginPage.txtCustomerName().sendKeys(customerName);

		loginPage.txtCustomerType().sendKeys("Customer Type B" + Keys.ENTER);

		loginPage.txtEmail().sendKeys(email);

		loginPage.txtContactNo().sendKeys(contactNo);

		loginPage.txtAddress().sendKeys(address);

		loginPage.txtPinCode().sendKeys(pincode);

		loginPage.txtCountry().sendKeys(country + Keys.ENTER);

		loginPage.txtState().sendKeys(state + Keys.ENTER);

		loginPage.txtCity().sendKeys(city + Keys.ENTER);

		// Click On Submit Btn
		genericHelper.clickWithJavascriptExecutor(loginPage.btnSubmit());

		// check MESSAGE
		String msg = errorHandlePage.toastifyMessage().getText();
		System.out.println("TC5 Actual :" + msg);
		System.out.println("TC5 Expected:" + customerTypeErrorMsgExp);

		if (msg.equalsIgnoreCase("Customer name already exists")) {
			reportHelper.onTestSuccess(test, "TC5 Passed");
			reportHelper.generateLogFullScreenSS(test, "");
		} else {
			reportHelper.onTestFailure(test, msg);
			reportHelper.generateLogFullScreenSS(test, "");
		}
	}
}