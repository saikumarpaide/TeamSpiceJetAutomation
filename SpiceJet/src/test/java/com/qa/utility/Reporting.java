package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	@Override
	public void onStart(ITestContext testContext) {

		String DateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String reportName = "Test-Report-" + DateStamp + ".html";
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + reportName);

		extentReports = new ExtentReports();

		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("HostName", "localhost");
		extentReports.setSystemInfo("QA", "SAIKUMAR");
		extentReports.setSystemInfo("OS", "Windows 10");

		extentHtmlReporter.config().setDocumentTitle("SpiceJet Automation ");
		extentHtmlReporter.config().setReportName("Functional Test Report");
		extentHtmlReporter.config().setTheme(Theme.STANDARD);
		extentHtmlReporter.config().setAutoCreateRelativePathMedia(true);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extentReports.flush();
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		extentTest.log(Status.PASS, "Test is Passed");

		String SSName = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";

		File file = new File(SSName);
		if (file.exists()) {
			try {
				extentTest.pass("Screenshot for the test Passed is : " + extentTest.addScreenCaptureFromPath(SSName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void onTestFailure(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		extentTest.log(Status.FAIL, "Test is Failed");
		extentTest.log(Status.FAIL, tr.getThrowable());

		String SSName = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";

		File file = new File(SSName);
		if (file.exists()) {
			try {
				extentTest.fail("Screenshot for the test failed is : " + extentTest.addScreenCaptureFromPath(SSName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		extentTest.log(Status.SKIP, "Test is Skipped");
	}

}
