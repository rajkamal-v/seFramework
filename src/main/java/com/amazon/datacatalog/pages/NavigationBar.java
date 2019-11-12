package com.amazon.datacatalog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

import com.amazon.datacatalog.base.BasePageObject;

public class NavigationBar extends BasePageObject {

	private By selectDropdownBox = By.id("searchDropdownBox");
	private By searchTextBox	 = By.id("twotabsearchtextbox");
	private By searchBtn		 = By.cssSelector("input.nav-input[type='submit']");

	public NavigationBar(WebDriver driver) {
		super(driver);
	}

	public ResultPage searchItemByCategory(String category, String itemName) {
		selectCategory(category);
		enterItemName(itemName);
		clickSearchBtn();
		return new ResultPage(driver);
	}

	private void clickSearchBtn() {
		find(searchBtn).click();
	}

	private void enterItemName(String itemName) {
		find(searchTextBox).sendKeys(itemName);
	}

	private void selectCategory(String category) {	
		selectFromDropdownByText(selectDropdownBox, category);
	}
	
}
