package com.expedia.india.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.expedia.india.base.Page;

public class CustomListener extends Page implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Skipped");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test Failed");
	}
}
