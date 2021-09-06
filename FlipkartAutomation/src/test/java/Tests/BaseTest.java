package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import utils.ExcelFileIO;


public class BaseTest {

	//initializing the WebDriver
	WebDriver driver;
	public static ExcelFileIO reader = null;

		

	// defining logger
	public static Logger logger = Logger.getLogger(BaseTest.class);
	public static RemoteWebDriver remotedriver;
	public static String LOG_FILE = ".\\Resources\\log4j.properties"; // defining location of log4j file
	static FileInputStream logfile = null;
	static File file = new File(".\\Resources\\config.properties"); //defining location of config.properties file
	static FileInputStream fis = null;
	protected static Properties prop = new Properties();
		
	static {
		try {
			fis = new FileInputStream(file);
			logfile = new FileInputStream(LOG_FILE);
			PropertyConfigurator.configure(logfile);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
			prop.load(logfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			reader = new ExcelFileIO(".\\Resources\\Data.xlsx");
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}
	
	@BeforeMethod 
	public void setUp() {
		
		
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe"); 
		driver = new ChromeDriver(); //launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
				
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
