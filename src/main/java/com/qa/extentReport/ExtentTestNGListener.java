package com.qa.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestNGListener implements ITestListener {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	// Set up the ExtentReports object and HTML Reporter
	public static ExtentReports createExtentReports() {
		// Define the file path for the report
		String reportFileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		File file = new File(System.getProperty("user.dir") + "/test-output/ExtentReport_" + reportFileName + ".html");

		// Create an HTML Reporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(file);
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Test Execution Report");

		// Create an ExtentReports instance and attach the HTML Reporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Add system information (optional)
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester", "Your Name");

		return extent;
	}

	@Override
	public void onStart(ITestContext context) {
		// Initialize ExtentReports
		extent = createExtentReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// Start a new test in ExtentReport
		test.set(extent.createTest(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Mark the test as passed
		test.get().pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Log the failure and add exception details
		test.get().fail("Test failed with exception: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Mark the test as skipped
		test.get().skip("Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		// Flush the report to save results
		extent.flush();
	}
}
