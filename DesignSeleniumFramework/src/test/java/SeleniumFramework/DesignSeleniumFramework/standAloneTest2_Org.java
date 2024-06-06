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

import SeleniumFramework.PageObjectModel.landingPage;

public class standAloneTest2_Org {
	
	public static void main(String[] args) throws InterruptedException
	{
		String productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		
		// Login to the application
		
		landingPage landingPage = new landingPage(driver);
		landingPage.loginApplication("mrityunjaydw.pd@gmail.com", "Punit@199731");
		
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mrityunjaydw.pd@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Punit@199731");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		//find element in the catalog and click on add to card
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		
		// Wait for the element
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("(//*[@class='btn btn-custom'])[3]")).click();
		
		// get cart product and checkout
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Checkout']")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'ta-results')]")));
		
		driver.findElement(By.xpath("(//*[contains(@class, 'ta-item')])[2]")).click();
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='hero-primary']")));
		
		String Confmessage = driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
		
		Assert.assertTrue(Confmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.quit();
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
