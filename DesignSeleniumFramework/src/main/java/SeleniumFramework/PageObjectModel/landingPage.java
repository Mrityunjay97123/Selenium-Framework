package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.abstractComponent;

public class landingPage extends abstractComponent {
	
	WebDriver driver;
	
	public landingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement PasswordEle;
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement Submit;
	
	
	public productCatalog  loginApplication( String email, String Password)
	{
		Username.sendKeys(email);
		PasswordEle.sendKeys(Password);
		Submit.click();
		
		productCatalog productCatalog = new productCatalog(driver);
		return productCatalog;
	}
	
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client/");
		
	}

}
