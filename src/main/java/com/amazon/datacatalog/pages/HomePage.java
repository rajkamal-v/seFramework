package com.amazon.datacatalog.pages;

import org.openqa.selenium.WebDriver;

import com.amazon.datacatalog.base.BasePageObject;

public class HomePage extends BasePageObject {

	private String homePageUrl = "https://www.amazon.com/";
	
	public NavigationBar navbar;

	public HomePage(WebDriver driver) {
		super(driver);
		this.navbar = new NavigationBar(driver);
		
	}

	/** Open page using it's url */
	public void open() {
		openUrl(homePageUrl);
		waitForLoad(driver);
	}


}
