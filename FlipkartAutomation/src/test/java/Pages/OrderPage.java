package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	// initializing the web driver
		WebDriver driver;

		public OrderPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}

		// locators for login 

		@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
		public WebElement Email;

		@FindBy(how = How.XPATH, using = "//input[@type='password']")
		public WebElement Password;
		
		@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
		public WebElement Login;

		// locator for search box
		@FindBy(how = How.NAME, using = "q")
		public WebElement TypeInSearch;

		// locator for clicking search
		@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")
		public WebElement ClickSearch;
				
		//locator for the 3rd mobile
		@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]")
		public WebElement Mobile;	
		
		// locator for Add to Cart
		@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
		public WebElement CartButton;	
		
		// locator for place order
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Place Order')]")
		public WebElement PlaceOrder;
				
		// locator for name
		@FindBy(how = How.NAME, using = "name")
		public WebElement EnterName;

		// locator for phone
		@FindBy(how = How.NAME, using = "phone")
		public WebElement EnterPhone;

		// locator for pin code
		@FindBy(how = How.NAME, using = "pincode")
		public WebElement pincode;

		// locator for locality
		@FindBy(how = How.XPATH, using = "//input[@tabindex='4']")
		public WebElement locality;

		// locator for address
		@FindBy(how = How.NAME, using = "addressLine1")
		public WebElement address;

		// locator for city
		@FindBy(how = How.NAME, using = "city")
		public WebElement city;

		// locator for state
		@FindBy(how = How.NAME, using = "state")
		public WebElement state;

		// locator for address type
		@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/label[1]/div[1]")
		public WebElement Type;

		// locator for save button
		@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save and Deliver Here')]")
		public WebElement save;

		// locator for continue button
		@FindBy(how = How.XPATH, using = "//button[contains(text(),'CONTINUE')]")
		public WebElement continuebutton;
			
		
		// method for entering email
		public void EnterEmail(String mail) {
			Email.sendKeys(mail);
		}

		// method for entering password
		public void EnterPassword(String password) {
			Password.sendKeys(password);
		}

		// method for clicking login
		public void ClickLogin() {
			Login.click();
		}	
				
		//method for search 
		public void TypeinSearchbox(String type) {
			TypeInSearch.sendKeys(type);
		}
				
		//method for clicking search
		public void Click() {
			ClickSearch.click();
		}	
		
		//method for clicking on 3rd mobile
		public void Click3rdmobile() {
			Mobile.click();
		}		
		
		//method for clicking on Add to Cart
		public void clickOnAddToCart() {
			CartButton.click();
		}
		
		// method for changing the new browser window
		static String winHandleBefore;

		public void changeWindow() {
			winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		}

		// method for closing the new browser window

		public void closeWindow() {
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}
		
		//method for clicking on place order
		public void ClickOnPlaceOrder() {
			PlaceOrder.click();
		}
		
		//method for entering name
		public void EnterFullName(String name) {
			EnterName.sendKeys(name);
		}	
				
		// method for entering phone no.
		public void EnterMobileNo(String phone) {
			EnterPhone.sendKeys(phone);
		}
						
		// method for entering phone no.
		public void EnterPin(String pin) {
			pincode.sendKeys(pin);
		}

		// method for entering phone no.
		public void EnterLocality(String localityy) {
			locality.sendKeys(localityy);
		}
	
		// method for entering address 
		public void EnterAddress(String addresss) {
			address.sendKeys(addresss);
		}			

		// method for entering city
		public void EnterCity() {
			city.click();
		}
		
		// method for entering state
		public void EnterState() {
			state.click();
		}		
		
		// method for entering state
		public void EnterType() {
			Type.click();
		}

		// method for entering state
		public void ClickSave() {
			save.click();
		}
		
		// method for clicking continue
		public void ClickContinue() {
			continuebutton.click();
		}
}
