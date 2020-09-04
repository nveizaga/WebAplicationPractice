package com.automationpractice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automationpractice.page.AddToCartPage;

public class AddToCartTest {
	
	WebDriver driver;
	AddToCartPage page;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		page = new AddToCartPage(driver);
	}
	
	@Test
	public void validateAddToCart() {
		Assert.assertTrue(page.validateAddToCart(driver, "1", "Dresses"));
	}

}
