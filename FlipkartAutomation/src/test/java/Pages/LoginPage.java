package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// initializing the web driver
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// locators for login page

	//@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	//public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	public WebElement Password;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	public WebElement Login;
	

	// methods
	public void EnterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void EnterPassword(String password) {
		Password.sendKeys(password);
	}

	public void ClickLogin() {
		Login.click();
	}
	
	//methods for invalid email and password
	public void EnterinvalidEmail(String invalidMail) {
		email.sendKeys(invalidMail);
	}
	
	public void EnterinvalidPassword(String invalidPass) {
		Password.sendKeys(invalidPass);
	}
}
