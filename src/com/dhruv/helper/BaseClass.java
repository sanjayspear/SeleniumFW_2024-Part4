package com.dhruv.helper;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static final Logger logger = LogManager.getLogger(BaseClass.class);
	protected WebDriver driver;
	

	@BeforeSuite
	public void configureLog4j() {
		// Set the system property for Log4j configuration file
		System.setProperty("log4j.configurationFile", "src/com/dhruv/helper/log4j2.xml");
		
	}

	@BeforeMethod
	public void setUp() {
		logger.info("Setting up the WebDriver Initialization");
		driver = initializeDriver();
	}

	@AfterMethod
	public void tearDown() {
		logger.info("Tearing down the WebDriver instance");
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver initializeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		String desiredVersion = "124.0.6367.207";
		WebDriverManager.chromedriver().driverVersion(desiredVersion).setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		return driver;
	}
}
