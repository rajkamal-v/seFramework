package com.amazon.datacatalog.resulttest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.datacatalog.base.BaseTest;
import com.amazon.datacatalog.pages.HomePage;
import com.amazon.datacatalog.pages.ResultPage;

public class SearchTest extends BaseTest{
	
	@Parameters({"category","itemName"})
	@Test(priority = 1)
	public void resultTest(String category, String itemName) {
		// Open Home Page
		HomePage homePage = new HomePage(driver);
		homePage.open();

		// Click Form Authentication Link
		ResultPage resultPage = homePage.navbar.searchItemByCategory(category, itemName);
		Assert.assertTrue(resultPage.title().contains("Amazon.com: "+itemName), "Title doesn't contain expected text.");
		System.out.println("End Test");
	}
	
}
