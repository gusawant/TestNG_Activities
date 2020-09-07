package TestNGActivity1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {

	WebDriver driver;

	@Test
	public void exampleTestCase() {

		// Check the title of the page

		String title = driver.getTitle();

		// Print the title of the page

		System.out.println("Page title is: " + title);

		// Assertion for page title

		Assert.assertEquals("Training Support", title);

		// Find the clickable link on the page and click it
		
		WebDriverWait dw = new WebDriverWait(driver, 45);

		WebElement element = dw.until(ExpectedConditions.visibilityOfElementLocated(By.id("about-link")));
		
		element.click();

		// Print title of new page

		System.out.println("New page title is: " + driver.getTitle());

		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}

	@BeforeMethod
	public void beforeMethod() {

		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		driver = new FirefoxDriver();

		// Open browser

		driver.get("https://www.training-support.net");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}

	@AfterMethod
	public void afterMethod() {

		// Close the browser

		driver.quit();

	}

}
