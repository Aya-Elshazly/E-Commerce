package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.searchPage;

public class SearchProductTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	searchPage searchObject;
	ProductDetailsPage detailsObject;
	@Test
	public void userCanSearchForProducts(){
		searchObject=new searchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productname.getText().equalsIgnoreCase(productName));
		
		
	}

}
