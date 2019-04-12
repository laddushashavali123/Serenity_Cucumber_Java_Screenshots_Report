package com.lumbela.SerenityCucumberTemplate.utils;

public class Constant {

	public static final String GECKO_DRIVER_DIRECTORY = System.getProperty("webdriver.gecko.driver")+".exe";
	public static final String CHROME_DRIVER_DIRECTORY = /*System.getProperty("user.dir")+*/System.getProperty("webdriver.chrome.driver")+".exe";
	public static final String IE_DRIVER_DIRECTORY = System.getProperty("webdriver.ie.driver")+".exe";
	public static final String EDGE_DRIVER_DIRECTORY = System.getProperty("webdriver.chrome.driver")+".exe";
	public static final String CONFIG_PROPERTIES_DIRECTORY = System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\UiTests.properties";

}
