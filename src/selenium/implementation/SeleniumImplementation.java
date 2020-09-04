package selenium.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumImplementation {
	
	Actions action;
		
	public void pressEnter() {
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void setText(String text,WebElement element) {
		element.sendKeys(text);
	}
	
	public void selectSizeByText(String text,WebElement selectSize) {
		Select selSize = new Select(selectSize);
		selSize.selectByVisibleText(text);
	}
	
	public void clickUsingJavaExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
		
	public void performMouseHover(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public boolean validateText(WebDriver driver, WebElement element,String expectedText) {
		String currentText = element.getText();
		if(currentText.equals(expectedText)) {
			return true;
		}
		else {
			return false;
		}
	}
}
