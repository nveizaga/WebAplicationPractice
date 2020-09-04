package com.automationpractice.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.implementation.SeleniumImplementation;

public class AddToCartPage {
	
	SeleniumImplementation selenium;
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement quantityWantedText;
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement selectSize;
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	WebElement addToCartButton;
	@FindBy(css="div#layer_cart a > span")
	WebElement proceedCheckoutButton;
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	WebElement cart;
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;
	@FindBy(xpath="//*[@id=\"product_5_27_0_0\"]/td[2]/small[2]/a")
	WebElement productDetail;

	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumImplementation();
		
	}
	public void selectElementBySearch(WebDriver driver,String optionProduct, String searchValueText) {
		WebElement searchValue = driver.findElement(By.xpath("//*[@id='search_query_top']"));
		searchValue.sendKeys(searchValueText);
		searchButton.click();
		//selenium.scrollDown(driver);
		
		WebElement elementToSelect = driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+optionProduct+"]/div/div[1]/div/a[1]/img"));
		selenium.performMouseHover(elementToSelect, driver);
			
	}
	
	public void clickOnMoreBtn(String optionProduct, WebDriver driver) {
		WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+optionProduct+"]/div/div[2]/div[2]/a[2]/span"));
		selenium.clickUsingJavaExecutor(driver, btnAddToCart);
	}
	
	public boolean validateAddToCart(WebDriver driver,String optionProduct,String searchValueText) {
		String quantityNewValue = "2";
		String sizeProduct = "L";
		String quantityExpected = "Cart "+ quantityNewValue +" Products";
		String sizeExpected = "Color : Yellow, Size : L";
		selectElementBySearch(driver,optionProduct,searchValueText);
		clickOnMoreBtn(optionProduct,driver);
		selenium.clear(quantityWantedText);
		selenium.setText(quantityNewValue, quantityWantedText);
		selenium.selectSizeByText(sizeProduct, selectSize);
		selenium.click(addToCartButton);
		selenium.clickUsingJavaExecutor(driver, proceedCheckoutButton);
		selenium.refresh(driver);
		if(selenium.validateText(driver, cart, quantityExpected)) {
			return selenium.validateText(driver, productDetail, sizeExpected);
		}
		else
		{
			return false;
		}
	}

}
