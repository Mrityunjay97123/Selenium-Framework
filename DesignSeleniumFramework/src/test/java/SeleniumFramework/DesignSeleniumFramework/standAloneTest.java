package SeleniumFramework.DesignSeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFramework.PageObjectModel.CartPage;
import SeleniumFramework.PageObjectModel.CheckOutPage;
import SeleniumFramework.PageObjectModel.ConfirmationPage;
import SeleniumFramework.PageObjectModel.landingPage;
import SeleniumFramework.PageObjectModel.productCatalog;

public class standAloneTest {
	
	public static void main(String[] args) throws InterruptedException
	{
		String productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		landingPage landingPage = new landingPage(driver);
		landingPage.goTo();
		productCatalog productCatalog = landingPage.loginApplication("mrityunjaydw.pd@gmail.com", "Punit@199731");
		List<WebElement> products= productCatalog.getProductList();
		productCatalog.addProductToCart(productname);
		CartPage cartpage = productCatalog.goToCartPage();
		CheckOutPage checkout = cartpage.checkout();
		checkout.SelectCountry("India");
		ConfirmationPage confirmationPage = checkout.submitOrder();
		String Confmessage = confirmationPage.confirmationpage();
		Assert.assertTrue(Confmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
