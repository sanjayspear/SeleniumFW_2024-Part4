package com.dhruv.helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{
	 WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Test is success and listener is listing to the test case");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
        WebDriver driver = ((BaseClass) currentClass).initializeDriver();
		// Screenshot Code
        String testName = result.getMethod().getMethodName();
        GenericUtils.captureScreenshot(driver, testName);
        
        // Print the name of the failed test case
        System.out.println("Test failed and screenshot of the failed test is captured. Test case name is: " + testName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
