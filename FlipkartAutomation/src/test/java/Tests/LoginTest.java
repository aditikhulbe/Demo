package Tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.LoginPage;
import utils.Screenshot;


public class LoginTest extends BaseTest{

	// defining the Excel sheet name
		private String sheetName = "Login";
		
	@Test
	public void loginTest() {
		
		
		// fetching the data from Excel Sheet
		String TestCase = "Login";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);

		// creating an object to call methods from LoginPage
		LoginPage login = new LoginPage(driver);

		// calling methods from LoginPage

		login.EnterEmail(testData.get("Email"));
		
		logger.info("user entered email successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		login.EnterPassword(testData.get("Password"));
		
		logger.info("user entered password successfully"); 
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		login.ClickLogin();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//validating the title of the page
		assertTrue(driver.getTitle().contains("Online Shopping Site"));
		logger.info("Title of login page successfully verified"); 
		logger.info("VALID LOGIN testCase PASSED"); 

		
	}
	
	
	
	@Test
	
	public void InvalidLogin() {
		
		// fetching the data from Excel Sheet
		String TestCase = "InvalidLogin";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);

		// creating an object to call methods from LoginPage
		LoginPage invalid = new LoginPage(driver);

		// calling methods from LoginPage
		invalid.EnterinvalidEmail(testData.get("Email"));
		logger.info("user entered invalid email successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		
		invalid.EnterinvalidPassword(testData.get("Password"));
		logger.info("user entered invalid password successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		invalid.ClickLogin();
		
		//taking screenshot of this screen
		Screenshot.takeScreenShot(driver, "invalid login");
		logger.info("screenshot of invalid login taken successfully"); 
		logger.info("INVALID LOGIN testCase PASSED"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
}
