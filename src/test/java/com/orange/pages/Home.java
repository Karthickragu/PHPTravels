package com.orange.pages;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.orange.base.Testengine;
import com.orange.utilities.Util;

public class Home extends Testengine {
	
	public WebDriver driver;
	public Util util;
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Util(driver);
	}
	
	
	
	@FindBy(xpath = "//a[@href = '#flights']")
	public static WebElement flightMode;
	
	@FindBy(xpath = "//input[@id = 'FlightsDateStart']")
	public static WebElement depart;
	
	
	@FindBy(xpath = "//input[@id = 'checkin']")
	public static WebElement checkIn;
	
	@FindBy(xpath = "//input[@id = 'checkout']")
	public static WebElement checkOut;
	
	
	//String selectedDateText = "//div[@class='datepicker--cell datepicker--cell-day' and @data-month = 1 and @data-year = '2020' and @data-date=";
	//String selectedDateText = "//div[3]//div[2]//div[2]//div[@class='datepicker--cell datepicker--cell-day -selected-' and @data-month = 1 and @data-year = '2020' and @data-date=";
	
//	left: -100000px; top: 558px;
	

	
	public static WebElement selectedDate;
	
	@FindBy(xpath = "//a[text() = 'Logout']")
	public static WebElement logOut;
	
	
	public void selectCheckIn(Integer dates) throws InterruptedException {
		util.waitforLoad(checkIn);

		flightMode.click();
		depart.click();
		Thread.sleep(3000);
		
		List<WebElement> calenders_available = driver.findElements(By.xpath("//div[@class='datepicker -bottom-left- -from-bottom-']"));
		System.out.println(calenders_available.size());
		for (int i=1; i <= calenders_available.size(); i++) {
			String selectedDateText = "(//div[@class = 'datepicker--cell datepicker--cell-day' or contains(@class,'-current-') or contains(@class,'-weekend-') and @data-year = '2020' and @data-month = 1 and @data-date = '29'])["+i+"]";
			Boolean assertion = driver.findElement(By.xpath(selectedDateText)).isDisplayed();
			System.out.println(assertion);
			if(assertion) {
				driver.findElement(By.xpath(selectedDateText)).click();
				break;
			}
		}
		
		
		
		Thread.sleep(5000);
		
		
		//List<WebElement> dates1 = driver.findElements(By.xpath("//div[3][1]//div[2][1]//div[1]//div[@class='datepicker--cell datepicker--cell-day' and @data-month = 1 and @data-year = '2020']"));
		
		/*
		for (int i=0; i<dates1.size(); i++) {
			System.out.println(dates1.get(i));
			System.out.println(dates1.get(i).getAttribute("data-date"));
			if(dates1.get(i).getAttribute("data-date").equals("28")) {
				System.out.println("It came inside the selected Date");
				dates1.get(i).click();
			}
			
			*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		flightMode.click();
		depart.click();
		Thread.sleep(1000);
		Thread.sleep(2000);
		WebElement dateSelected = driver.findElement(By.xpath("//div[3][1]//div[2][1]//div[1]//div[@class='datepicker--cell datepicker--cell-day' and @data-month = 1 and @data-year = '2020' and @data-date=28][1]"));
		Thread.sleep(2000);
		System.out.println("******************");
		System.out.println(dateSelected.getAttribute("data-date"));
		System.out.println("******************");
		depart.click();
		dateSelected.click();
		Thread.sleep(2000);

		
		/*
		checkIn.clear();
		Thread.sleep(1000);
		checkIn.click();
		Thread.sleep(1000);
		checkIn.sendKeys("28/03/2020");
	//	String dateSelected = selectedDateText +date+"]";
	//	System.out.println(dateSelected);
	//	driver.findElement(By.xpath(dateSelected)).click();
		Thread.sleep(2000);
		checkOut.click();
		Thread.sleep(2000);
		checkIn.click();
		
		*/
	}
}

