package com.amazon.datacatalog.pages;

import org.openqa.selenium.WebDriver;

import com.amazon.datacatalog.base.BasePageObject;

public class ResultPage extends BasePageObject{
	
	public NavigationBar navbar;
	
	public ResultPage(WebDriver driver) {
		super(driver);
		this.navbar = new NavigationBar(driver);
		waitForLoad(driver);
	}
	
}
