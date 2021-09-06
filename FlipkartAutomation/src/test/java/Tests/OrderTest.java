package Tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Pages.OrderPage;
import utils.Screenshot;

public class OrderTest extends BaseTest {

	// defining the Excel sheet name
	private String sheetName = "Order";

	@Test
	public void Order() {

		// fetching the data from Excel Sheet
		String TestCase = "Order";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);

		// creating an object to call methods from OrderPage
		OrderPage order = new OrderPage(driver);

		order.EnterEmail(testData.get("email"));
		logger.info("user entered email successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		order.EnterPassword(testData.get("password"));
		logger.info("user entered email successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		order.ClickLogin();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		order.TypeinSearchbox(testData.get("Type_in_Search"));
		logger.info("user entered the item to be searched successfully"); 
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.Click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//taking screenshot of this screen
		Screenshot.takeScreenShot(driver, "search result for Mobile");
		logger.info("screenshot taken for the search result page"); 
		

		// scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.Click3rdmobile();

		order.changeWindow();
		
		logger.info("user clicked on the 3rd item of the search result page"); 

		
		//taking screenshot of this screen
        Screenshot.takeScreenShot(driver, "mobile detail page");
				
				
		// scrolling down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,300)", "");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.clickOnAddToCart();
		logger.info("Item added to cart successfully"); 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.ClickOnPlaceOrder();

		// validating the title of the page
		assertTrue(driver.getTitle().contains("Secure Payment"));
		logger.info("Validated the title of the page successfully"); 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.EnterFullName(testData.get("Name"));
		
		logger.info("user entered name successfully"); 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.EnterMobileNo(testData.get("Mobile_no"));
		
		logger.info("user entered mobile no. successfully"); 
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		order.EnterPin(testData.get("Pin"));
		
		logger.info("user entered pin code successfully"); 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.EnterLocality(testData.get("Locality"));
		
		logger.info("user entered locality successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// scrolling down
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,300)", "");

		order.EnterAddress(testData.get("Address"));

		logger.info("user entered the address successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.EnterCity();
		
		logger.info("user entered city successfully"); 

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		order.EnterState();
		
		logger.info("user entered state successfully"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		order.EnterType();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		order.ClickSave();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//taking screenshot of this screen
		Screenshot.takeScreenShot(driver, "order summary");
		logger.info("user entered all details successfully"); 
				
				
		// scrolling down
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,300)", "");

		order.ClickContinue();
		logger.info("ORDER TILL PAYMENT PAGE TestCase PASSED"); 
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
