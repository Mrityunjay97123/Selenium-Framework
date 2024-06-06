package SeleniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.abstractComponent;

public class ConfirmationPage extends abstractComponent {
	
	WebDriver driver;
	
public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='hero-primary']")
	WebElement ConfirmationMessage;
	
	public String confirmationpage()
	{
		return ConfirmationMessage.getText();
	}

}
