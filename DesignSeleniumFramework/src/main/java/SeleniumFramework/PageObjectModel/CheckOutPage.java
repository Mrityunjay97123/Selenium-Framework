package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFramework.AbstractComponent.abstractComponent;

public class CheckOutPage extends abstractComponent {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[text()='Place Order ']")
	WebElement Submit;
	
	@FindBy(xpath = "(//*[contains(@class, 'ta-item')])[2]")
	WebElement SelectCountry;
	
	
	@FindBy(xpath = "//*[@placeholder='Select Country']")
	WebElement Country;
	
	By Result = By.xpath("//*[contains(@class, 'ta-results')]");
	
	public void SelectCountry(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		waitForElementToAppear(Result);
		
		driver.findElement(By.xpath("(//*[contains(@class, 'ta-item')])[2]")).click();
	}
	
	public ConfirmationPage submitOrder()
	{
		Submit.click();
		ConfirmationPage conformationPage = new ConfirmationPage(driver);
		return conformationPage;
		
	}
	
	

}
