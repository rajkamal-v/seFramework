package com.amazon.datacatalog.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}

	protected void openUrl(String url) {
		System.out.println("Opening page: " + url);
		driver.get(url);
		System.out.println("Page opened!");
	}
	
	public String title() {
		return driver.getTitle();	
	}  
	

	protected WebElement find(By locator) {
		WebElement element = driver.findElement(locator);
		System.out.println("Element Tag Name "+element.getTagName());
		return element;
	}
	
	protected void selectFromDropdownByText(By locator, String text) {
		WebElement select = find(locator);
		try {
			Select dropdownBox = new Select(select);
			dropdownBox.selectByVisibleText(text);
		}
		catch(ElementNotInteractableException ex) {
			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, text);
		}
	}
	
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        this.wait.until(pageLoadCondition);
        System.out.println("Page Loaded: "+((JavascriptExecutor)driver).executeScript("return document.readyState").toString());
    }
}

