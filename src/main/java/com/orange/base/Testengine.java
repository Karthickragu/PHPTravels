package com.orange.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testengine implements Base {

	public static Logger orangelog;
	public static ExtentReports report;
	public static ExtentTest test;
	public static WebDriver driver;
	public static Short totalTCs = 0;
	public static Short failedTCs = 0;
	public static Short passedTCs = 0;
	public static Short skippedTCs = 0;
	public static Boolean assersion = false;
	public static SoftAssert verify;

	@BeforeSuite
	public void initiate() {
		try {
			orangelog = Logger.getLogger("log4j.properties");
		} catch (Exception e) {
			System.out.println("Log4j configuration not found in the system");
		}

		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
			test = report.startTest("ExtentDemo");
		} catch (Exception e) {
			System.out.println("User Directory is not reachable");
		}
	}

	@BeforeTest
	@Parameters({ "value" })
	public void setUp(String value) {
		System.out.println("Selected Browser is " + value);

		if (value.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (value.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		if (value.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@BeforeMethod()
	public void startUp() {
		driver.get("https://www.phptravels.net/home");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
	}

	@AfterTest
	public void terminate() {
	//	driver.quit();

	}

	@AfterSuite
	public void generateReports() {
		System.out.println("Total Number of Test Cases are : " + totalTCs + " in which ");
		System.out.println("Total Test Cases Passed :" + passedTCs);
		System.out.println("Total Test Cases Failed :" + failedTCs);
		System.out.println("Total Test Cases Skipped :" + skippedTCs);

	}

	public void setUp() {
		// TODO Auto-generated method stub

	}

}
