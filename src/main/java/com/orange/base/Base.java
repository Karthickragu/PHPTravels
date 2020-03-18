package com.orange.base;


public interface Base {

	// Initiate Logger
	// Initiate Extent Reports
	// Initiate Config file
	
	public void initiate(); 

	public void setUp(String value);
		// Initiate WebDriver
		// Initiate Path or take WebDriverManager
	
	public void startUp();
	
	public void tearDown();
		// Close Webdriver
	

	public void terminate();
		// Quit Webdriver
	
	public void generateReports();

}
