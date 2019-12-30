package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.searchPage;

public class SearchProductAutoComplete extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObject;
	ProductDetailsPage detailsObject;
	@Test
	public void userCanSearchWithAutoSuggest() throws InterruptedException{
		searchObject=new searchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest("mac");
		Assert.assertTrue(detailsObject.productname.getText().equalsIgnoreCase(productName));
		
	}

}
