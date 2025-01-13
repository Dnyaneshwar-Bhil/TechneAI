package com.co.utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.co.core.Login;
import com.co.pagelayer.ErrorHandlePage;
import com.co.pagelayer.LoginPage;
import com.sharedutils.ExcelHelper;
import com.sharedutils.GenericHelper;
import com.sharedutils.MasterDto;
import com.sharedutils.PropertyHelper;
import com.sharedutils.ReportsHelper;
import com.sharedutils.ScreenShotHelper;

public class ProjectFunctions implements ProjectConstants {

	public GenericHelper genericHelper = new GenericHelper();
	public ExcelHelper excelHelper = new ExcelHelper();
	public PropertyHelper propertyHelper = new PropertyHelper();
	public ReportsHelper reportHelper = new ReportsHelper();
	public ScreenShotHelper ssHelper = new ScreenShotHelper();
	public static MasterDto masterDto = new MasterDto();

	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static WebDriver driver;
	public static XSSFSheet sheet;

	protected static boolean isLoggedIn = false;

	// Login
	public static Login login;
	
	// DOM Pages
	public static LoginPage loginPage;
	public static ErrorHandlePage errorHandlePage;

	public void pageInitialiazation(WebDriver driver) {

		// ----------- Login Functionality -----------
		login = new Login();
		loginPage = new LoginPage();
		errorHandlePage = new ErrorHandlePage();

	}

}
