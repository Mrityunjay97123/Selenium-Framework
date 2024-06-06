package SeleniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.abstractComponent;

public class CartPage extends abstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[text()='Checkout']")
	WebElement CheckoutButton;
	
	
	public CheckOutPage checkout()
	{
		CheckoutButton.click();
		CheckOutPage checkout = new CheckOutPage(driver);
		return checkout;
	}
	
	

}
