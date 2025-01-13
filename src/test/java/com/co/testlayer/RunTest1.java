package com.co.testlayer;

import java.util.Map;

import org.testng.annotations.Test;

import com.co.utils.MasterClass;

public class RunTest1 extends MasterClass {

	@Test
	public void add() throws InterruptedException, Exception {

		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(excelPath + "Exam.xlsx", "Sheet1"); rowIndex++) {
			Map<String, String> orderData = excelHelper.readExcelDataAndMap(excelPath + "Exam.xlsx", "Sheet1",
					rowIndex);
			for (Map.Entry<String, String> entry : orderData.entrySet()) {
				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}
			if (rowIndex == 1) {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				login.TC1(driver, "AmreenS", "12345678");
				Thread.sleep(2000);
				driver.navigate().refresh();
				// Access from the properties file
				String url = getProperty("ProjectURL");
				System.out.println("URL:-------------- " + url);
				driver.navigate().to(url);
			}
			if (rowIndex == 2) {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				login.TC2(driver, "AmreenS", "12345678");
				Thread.sleep(2000);
				driver.navigate().refresh();
				// Access from the properties file
				String url = getProperty("ProjectURL");
				System.out.println("URL:-------------- " + url);
				driver.navigate().to(url);
			}
			if (rowIndex == 3) {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				login.TC3(driver, "AmreenS", "12345678");
				Thread.sleep(2000);
				driver.navigate().refresh();
				// Access from the properties file
				String url = getProperty("ProjectURL");
				System.out.println("URL:-------------- " + url);
				driver.navigate().to(url);
			}

			if (rowIndex == 4) {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				login.TC4(driver, "AmreenS", "12345678");
				Thread.sleep(2000);
				driver.navigate().refresh();
				// Access from the properties file
				String url = getProperty("ProjectURL");
				System.out.println("URL:-------------- " + url);
				driver.navigate().to(url);
			}

			if (rowIndex == 5) {
				test = reportHelper.createTestCase(test, extentReports, masterDto);
				login.TC5(driver, "AmreenS", "12345678");
				Thread.sleep(2000);
				driver.navigate().refresh();
				// Access from the properties file
				String url = getProperty("ProjectURL");
				System.out.println("URL:-------------- " + url);
				driver.navigate().to(url);
			}
		}

	}

}
