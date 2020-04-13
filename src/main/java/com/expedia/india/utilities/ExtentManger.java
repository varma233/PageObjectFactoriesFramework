package com.expedia.india.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.expedia.india.base.Page;

@SuppressWarnings("deprecation")
public class ExtentManger extends Page {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			ExtentHtmlReporter reporter = new ExtentHtmlReporter(
					rootDirectory + "\\target\\extentreport\\\\index.html");
			reporter.config().setEncoding("utf-8");
			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Automation Test Results");
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss.SSS");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Build Number", "1.0");
			extent.setSystemInfo("Environement", "Staging");
			extent.setSystemInfo("OS architecture", System.getProperty("os.arch"));
			extent.setSystemInfo("OS Name", System.getProperty("os.name"));
			extent.setSystemInfo("OS Version", System.getProperty("os.version"));

		}
		return extent;

	}
}
