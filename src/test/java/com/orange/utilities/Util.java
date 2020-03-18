package com.orange.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	private WebDriver driver;
	public static WebDriverWait wait;

	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforLoad(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
