package com.co.utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class MasterClass extends ProjectFunctions {
	protected Properties properties = new Properties();

	public MasterClass() {
		try {
			// Load the config.properties from the classpath
			InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return;
			}
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	@BeforeSuite(alwaysRun = true)
	public void preSuiteHandler() throws Exception {

		masterDto.setAttribute("QA Name", qaName);
		masterDto.setAttribute("Ptoject Title", projectTitle);
		masterDto.setAttribute("Documement Title", docTitle);
		masterDto.setAttribute("Report Name", reportName);
		masterDto.setAttribute("User Name", username);

		extentReports = reportHelper.generateReport(masterDto);
		test = extentReports.createTest("Setup");

		String browser = "chrome";
		driver = genericHelper.startBrowser(test, browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		pageInitialiazation(driver);

		// Load properties from the base class
		String url = getProperty("ProjectURL");
		genericHelper.navigateToURL(test, url);
		Thread.sleep(3000);
	}

	@AfterMethod(alwaysRun = true)
	public void postMethodHandler(ITestResult result) throws IOException, Exception {
		reportHelper.tearDown(test, result);
		extentReports.flush();
		// new added Extra line
//		driver.close();
//		driver.navigate().refresh(); // Refreshes the current page
	}

	@AfterSuite(alwaysRun = true)
	public void postSuiteHandler() throws IOException, Exception {

		isLoggedIn = false;
		// new added Extra line

		// Quit the driver after all tests are completed
		if (driver != null) {
			driver.quit(); // Closes all browser windows and ends the session
		}

	}

}
