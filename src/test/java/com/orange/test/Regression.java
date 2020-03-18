package com.orange.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orange.base.Testengine;
import com.orange.pages.Home;
import com.orange.utilities.Util;


@Listeners(com.orange.test.Regression.class)
public class Regression extends Testengine implements ITestListener {
	
	public static Util util; 
	public static Home home; 
	
	@BeforeClass
	public void initDriver() {
		home = new Home(driver);
	}
	
	@Test(priority = 1)
	public void test_TC001() throws InterruptedException {
		home.selectCheckIn(28);
		Thread.sleep(5000);
	}
	
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started Successfully...");
		totalTCs = (short) (totalTCs + 1);
	}

	public void onTestSuccess(ITestResult result) {
		passedTCs = (short) (passedTCs + 1);
	}

	public void onTestFailure(ITestResult result) {
		failedTCs = (short) (failedTCs + 1);
	}

	public void onTestSkipped(ITestResult result) {
		skippedTCs = (short) (skippedTCs + 1);
	}

	public void onStart(ITestContext context) {
		System.out.println("On Start Context");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test case completed...");
	}


}
